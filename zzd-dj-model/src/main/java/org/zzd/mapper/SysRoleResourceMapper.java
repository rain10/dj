package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.SysRoleResource;
import org.zzd.pojo.SysRoleResourceExample;
import org.zzd.pojo.SysRoleResourceKey;

public interface SysRoleResourceMapper {
    int countByExample(SysRoleResourceExample example);

    int deleteByExample(SysRoleResourceExample example);

    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    List<SysRoleResource> selectByExample(SysRoleResourceExample example);

    SysRoleResource selectByPrimaryKey(SysRoleResourceKey key);

    int updateByExampleSelective(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByExample(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}