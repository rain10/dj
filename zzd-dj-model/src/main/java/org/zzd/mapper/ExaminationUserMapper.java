package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationUser;
import org.zzd.pojo.ExaminationUserExample;

public interface ExaminationUserMapper {
    int countByExample(ExaminationUserExample example);

    int deleteByExample(ExaminationUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationUser record);

    int insertSelective(ExaminationUser record);

    List<ExaminationUser> selectByExample(ExaminationUserExample example);

    ExaminationUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationUser record, @Param("example") ExaminationUserExample example);

    int updateByExample(@Param("record") ExaminationUser record, @Param("example") ExaminationUserExample example);

    int updateByPrimaryKeySelective(ExaminationUser record);

    int updateByPrimaryKey(ExaminationUser record);
}