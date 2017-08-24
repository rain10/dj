package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.AnswerUser;
import org.zzd.pojo.AnswerUserExample;

public interface AnswerUserMapper {
    int countByExample(AnswerUserExample example);

    int deleteByExample(AnswerUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AnswerUser record);

    int insertSelective(AnswerUser record);

    List<AnswerUser> selectByExample(AnswerUserExample example);

    AnswerUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnswerUser record, @Param("example") AnswerUserExample example);

    int updateByExample(@Param("record") AnswerUser record, @Param("example") AnswerUserExample example);

    int updateByPrimaryKeySelective(AnswerUser record);

    int updateByPrimaryKey(AnswerUser record);
}