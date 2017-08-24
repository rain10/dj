package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationType;
import org.zzd.pojo.ExaminationTypeExample;

public interface ExaminationTypeMapper {
    int countByExample(ExaminationTypeExample example);

    int deleteByExample(ExaminationTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationType record);

    int insertSelective(ExaminationType record);

    List<ExaminationType> selectByExample(ExaminationTypeExample example);

    ExaminationType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationType record, @Param("example") ExaminationTypeExample example);

    int updateByExample(@Param("record") ExaminationType record, @Param("example") ExaminationTypeExample example);

    int updateByPrimaryKeySelective(ExaminationType record);

    int updateByPrimaryKey(ExaminationType record);
}