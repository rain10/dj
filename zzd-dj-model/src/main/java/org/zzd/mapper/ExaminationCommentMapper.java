package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ExaminationComment;
import org.zzd.pojo.ExaminationCommentExample;

public interface ExaminationCommentMapper {
    int countByExample(ExaminationCommentExample example);

    int deleteByExample(ExaminationCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExaminationComment record);

    int insertSelective(ExaminationComment record);

    List<ExaminationComment> selectByExample(ExaminationCommentExample example);

    ExaminationComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExaminationComment record, @Param("example") ExaminationCommentExample example);

    int updateByExample(@Param("record") ExaminationComment record, @Param("example") ExaminationCommentExample example);

    int updateByPrimaryKeySelective(ExaminationComment record);

    int updateByPrimaryKey(ExaminationComment record);
}