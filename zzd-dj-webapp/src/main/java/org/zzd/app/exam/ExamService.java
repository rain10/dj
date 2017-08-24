package org.zzd.app.exam;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.Examination;
import org.zzd.pojo.ExaminationWithBLOBs;
import org.zzd.pojo.SysUser;

public interface ExamService {
ArainResult load_grid(int page, int rows, String sort,String order,String title,Integer type,SysUser user);
	
	ArainResult save_01(ExaminationWithBLOBs examination);
	
	ArainResult load_01(ExaminationWithBLOBs examination);
	
	ArainResult load_exam_user(SysUser user);
}
