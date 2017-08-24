package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ContentAttachmentsExample;
import org.zzd.pojo.ContentAttachmentsKey;

public interface ContentAttachmentsMapper {
    int countByExample(ContentAttachmentsExample example);

    int deleteByExample(ContentAttachmentsExample example);

    int deleteByPrimaryKey(ContentAttachmentsKey key);

    int insert(ContentAttachmentsKey record);

    int insertSelective(ContentAttachmentsKey record);

    List<ContentAttachmentsKey> selectByExample(ContentAttachmentsExample example);

    int updateByExampleSelective(@Param("record") ContentAttachmentsKey record, @Param("example") ContentAttachmentsExample example);

    int updateByExample(@Param("record") ContentAttachmentsKey record, @Param("example") ContentAttachmentsExample example);
}