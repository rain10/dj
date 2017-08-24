package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.MemberTest;
import org.zzd.pojo.MemberTestExample;
import org.zzd.pojo.MemberTestKey;

public interface MemberTestMapper {
    int countByExample(MemberTestExample example);

    int deleteByExample(MemberTestExample example);

    int deleteByPrimaryKey(MemberTestKey key);

    int insert(MemberTest record);

    int insertSelective(MemberTest record);

    List<MemberTest> selectByExample(MemberTestExample example);

    MemberTest selectByPrimaryKey(MemberTestKey key);

    int updateByExampleSelective(@Param("record") MemberTest record, @Param("example") MemberTestExample example);

    int updateByExample(@Param("record") MemberTest record, @Param("example") MemberTestExample example);

    int updateByPrimaryKeySelective(MemberTest record);

    int updateByPrimaryKey(MemberTest record);
}