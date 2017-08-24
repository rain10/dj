package org.zzd.app.paper;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.ExaminationPaper;
import org.zzd.pojo.SysUser;

public interface PaperService {
ArainResult load_grid(int page, int rows, String sort,String order,String title,SysUser user);
	
	ArainResult save_01(ExaminationPaper paper,String questions);
	
	ArainResult edit_01(ExaminationPaper paper);
	
	ArainResult load_quesyion_id(ExaminationPaper paper);

	ArainResult save_suiji(ExaminationPaper paper, Integer count);

	ArainResult load_combogrid(int page, int rows, String title,SysUser user);
}
