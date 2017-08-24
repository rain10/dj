package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.PaperQuestionExample;
import org.zzd.pojo.PaperQuestionKey;

public interface PaperQuestionMapper {
    int countByExample(PaperQuestionExample example);

    int deleteByExample(PaperQuestionExample example);

    int deleteByPrimaryKey(PaperQuestionKey key);

    int insert(PaperQuestionKey record);

    int insertSelective(PaperQuestionKey record);

    List<PaperQuestionKey> selectByExample(PaperQuestionExample example);

    int updateByExampleSelective(@Param("record") PaperQuestionKey record, @Param("example") PaperQuestionExample example);

    int updateByExample(@Param("record") PaperQuestionKey record, @Param("example") PaperQuestionExample example);
}