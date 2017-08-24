package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationAnswer;
import org.zzd.pojo.ExaminationAnswerExample;

public interface ExaminationAnswerMapper {
    int countByExample(ExaminationAnswerExample example);

    int deleteByExample(ExaminationAnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationAnswer record);

    int insertSelective(ExaminationAnswer record);

    List<ExaminationAnswer> selectByExample(ExaminationAnswerExample example);

    ExaminationAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByExample(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByPrimaryKeySelective(ExaminationAnswer record);

    int updateByPrimaryKey(ExaminationAnswer record);
}