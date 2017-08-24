package org.zzd.system.aspect.point;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zzd.system.aspect.annotation.SystemControllerLog;


@Aspect
@Component
public class SystemLogAspect {
	
	//本地异常日志记录对象  
	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class); 
	
	//Controller层切点  
	@Pointcut("@annotation(org.zzd.system.aspect.annotation.SystemControllerLog)")  
	public  void controllerAspect() {  
	}  
	
	@Before("controllerAspect()")
	private void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
		String ip = request.getRemoteAddr(); 
		
		try {
			System.out.println("=====前置通知开始=====");  
			System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
			System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));  
			System.out.println("请求IP:" + ip);
			System.out.println("=====前置通知结束=====");  
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("==前置通知异常==");  
			logger.error("异常信息:{}", e.getMessage());  
		}  
	}
	
	
	@SuppressWarnings("rawtypes")
	public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {  
		String targetName = joinPoint.getTarget().getClass().getName();  
		String methodName = joinPoint.getSignature().getName();  
		Object[] arguments = joinPoint.getArgs();  
		Class targetClass = Class.forName(targetName);  
		Method[] methods = targetClass.getMethods();  
		String description = "";  
		for (Method method : methods) {  
			if (method.getName().equals(methodName)) {  
				Class[] clazzs = method.getParameterTypes();  
				if (clazzs.length == arguments.length) {  
					description = method.getAnnotation(SystemControllerLog. class).description();  
					break;  
				}  
			}  
		}  
		return description;  
	} 
}
