package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ContentComments;
import org.zzd.pojo.ContentCommentsExample;
import org.zzd.pojo.ContentCommentsWithBLOBs;

public interface ContentCommentsMapper {
    int countByExample(ContentCommentsExample example);

    int deleteByExample(ContentCommentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContentCommentsWithBLOBs record);

    int insertSelective(ContentCommentsWithBLOBs record);

    List<ContentCommentsWithBLOBs> selectByExampleWithBLOBs(ContentCommentsExample example);

    List<ContentComments> selectByExample(ContentCommentsExample example);

    ContentCommentsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentCommentsWithBLOBs record, @Param("example") ContentCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") ContentCommentsWithBLOBs record, @Param("example") ContentCommentsExample example);

    int updateByExample(@Param("record") ContentComments record, @Param("example") ContentCommentsExample example);

    int updateByPrimaryKeySelective(ContentCommentsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ContentCommentsWithBLOBs record);

    int updateByPrimaryKey(ContentComments record);
}