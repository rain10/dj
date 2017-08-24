package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.SysRegion;
import org.zzd.pojo.SysRegionExample;

public interface SysRegionMapper {
    int countByExample(SysRegionExample example);

    int deleteByExample(SysRegionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRegion record);

    int insertSelective(SysRegion record);

    List<SysRegion> selectByExample(SysRegionExample example);

    SysRegion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRegion record, @Param("example") SysRegionExample example);

    int updateByExample(@Param("record") SysRegion record, @Param("example") SysRegionExample example);

    int updateByPrimaryKeySelective(SysRegion record);

    int updateByPrimaryKey(SysRegion record);
}