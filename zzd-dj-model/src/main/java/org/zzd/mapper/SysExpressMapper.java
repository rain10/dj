package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.SysExpress;
import org.zzd.pojo.SysExpressExample;

public interface SysExpressMapper {
    int countByExample(SysExpressExample example);

    int deleteByExample(SysExpressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysExpress record);

    int insertSelective(SysExpress record);

    List<SysExpress> selectByExample(SysExpressExample example);

    SysExpress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysExpress record, @Param("example") SysExpressExample example);

    int updateByExample(@Param("record") SysExpress record, @Param("example") SysExpressExample example);

    int updateByPrimaryKeySelective(SysExpress record);

    int updateByPrimaryKey(SysExpress record);
}