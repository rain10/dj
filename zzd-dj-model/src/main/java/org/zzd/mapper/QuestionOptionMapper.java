package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.QuestionOption;
import org.zzd.pojo.QuestionOptionExample;

public interface QuestionOptionMapper {
    int countByExample(QuestionOptionExample example);

    int deleteByExample(QuestionOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuestionOption record);

    int insertSelective(QuestionOption record);

    List<QuestionOption> selectByExample(QuestionOptionExample example);

    QuestionOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuestionOption record, @Param("example") QuestionOptionExample example);

    int updateByExample(@Param("record") QuestionOption record, @Param("example") QuestionOptionExample example);

    int updateByPrimaryKeySelective(QuestionOption record);

    int updateByPrimaryKey(QuestionOption record);
}