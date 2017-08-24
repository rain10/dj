package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.Examination;
import org.zzd.pojo.ExaminationExample;
import org.zzd.pojo.ExaminationWithBLOBs;

public interface ExaminationMapper {
    int countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationWithBLOBs record);

    int insertSelective(ExaminationWithBLOBs record);

    List<ExaminationWithBLOBs> selectByExampleWithBLOBs(ExaminationExample example);

    List<Examination> selectByExample(ExaminationExample example);

    ExaminationWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationWithBLOBs record, @Param("example") ExaminationExample example);

    int updateByExampleWithBLOBs(@Param("record") ExaminationWithBLOBs record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByPrimaryKeySelective(ExaminationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExaminationWithBLOBs record);

    int updateByPrimaryKey(Examination record);
}