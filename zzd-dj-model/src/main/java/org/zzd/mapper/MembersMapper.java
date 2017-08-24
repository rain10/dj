package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.Members;
import org.zzd.pojo.MembersExample;

public interface MembersMapper {
    int countByExample(MembersExample example);

    int deleteByExample(MembersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Members record);

    int insertSelective(Members record);

    List<Members> selectByExample(MembersExample example);

    Members selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByExample(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByPrimaryKeySelective(Members record);

    int updateByPrimaryKey(Members record);
}