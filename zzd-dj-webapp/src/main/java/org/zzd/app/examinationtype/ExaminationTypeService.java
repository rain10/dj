package org.zzd.app.examinationtype;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationType;
import org.zzd.pojo.SysUser;

public interface ExaminationTypeService {
	ArainResult load_grid(int page, int rows, String sort,String order,String title,SysUser user);
	
	ArainResult save_01(ExaminationType type);
	
	ArainResult edit_01(ExaminationType type);
	
	ArainResult load_type(ExaminationQuestions questions,SysUser user);
}
