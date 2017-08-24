package org.zzd.app.examination;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.ExaminationAnswer;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.SysUser;

public interface ExaminationService {
	ArainResult load_grid(int page, int rows, String sort,String order,String title,String type,SysUser user);
	
	ArainResult save_01(ExaminationQuestions questions,String answerJson);
	
	ArainResult edit_01(ExaminationQuestions questions);
	
	ArainResult load_edit_grid(ExaminationAnswer answer);
	
	ArainResult paper_load_grid(int page, int rows, String sort,String order,String title,String type,SysUser user);
}
