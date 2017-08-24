package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationPaper;
import org.zzd.pojo.ExaminationPaperExample;

public interface ExaminationPaperMapper {
    int countByExample(ExaminationPaperExample example);

    int deleteByExample(ExaminationPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationPaper record);

    int insertSelective(ExaminationPaper record);

    List<ExaminationPaper> selectByExample(ExaminationPaperExample example);

    ExaminationPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationPaper record, @Param("example") ExaminationPaperExample example);

    int updateByExample(@Param("record") ExaminationPaper record, @Param("example") ExaminationPaperExample example);

    int updateByPrimaryKeySelective(ExaminationPaper record);

    int updateByPrimaryKey(ExaminationPaper record);
}