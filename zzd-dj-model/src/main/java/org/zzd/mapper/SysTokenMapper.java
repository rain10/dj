package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.SysToken;
import org.zzd.pojo.SysTokenExample;

public interface SysTokenMapper {
    int countByExample(SysTokenExample example);

    int deleteByExample(SysTokenExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysToken record);

    int insertSelective(SysToken record);

    List<SysToken> selectByExample(SysTokenExample example);

    SysToken selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysToken record, @Param("example") SysTokenExample example);

    int updateByExample(@Param("record") SysToken record, @Param("example") SysTokenExample example);

    int updateByPrimaryKeySelective(SysToken record);

    int updateByPrimaryKey(SysToken record);
}