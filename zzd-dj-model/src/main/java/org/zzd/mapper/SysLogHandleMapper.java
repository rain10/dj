package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.SysLogHandle;
import org.zzd.pojo.SysLogHandleExample;

public interface SysLogHandleMapper {
    int countByExample(SysLogHandleExample example);

    int deleteByExample(SysLogHandleExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(SysLogHandle record);

    int insertSelective(SysLogHandle record);

    List<SysLogHandle> selectByExample(SysLogHandleExample example);

    SysLogHandle selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") SysLogHandle record, @Param("example") SysLogHandleExample example);

    int updateByExample(@Param("record") SysLogHandle record, @Param("example") SysLogHandleExample example);

    int updateByPrimaryKeySelective(SysLogHandle record);

    int updateByPrimaryKey(SysLogHandle record);
}