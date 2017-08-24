package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationQuestionsExample;

public interface ExaminationQuestionsMapper {
    int countByExample(ExaminationQuestionsExample example);

    int deleteByExample(ExaminationQuestionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationQuestions record);

    int insertSelective(ExaminationQuestions record);

    List<ExaminationQuestions> selectByExample(ExaminationQuestionsExample example);

    ExaminationQuestions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationQuestions record, @Param("example") ExaminationQuestionsExample example);

    int updateByExample(@Param("record") ExaminationQuestions record, @Param("example") ExaminationQuestionsExample example);

    int updateByPrimaryKeySelective(ExaminationQuestions record);

    int updateByPrimaryKey(ExaminationQuestions record);
}