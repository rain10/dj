package org.zzd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.ContentPropellingExample;
import org.zzd.pojo.ContentPropellingKey;

public interface ContentPropellingMapper {
    int countByExample(ContentPropellingExample example);

    int deleteByExample(ContentPropellingExample example);

    int deleteByPrimaryKey(ContentPropellingKey key);

    int insert(ContentPropelling record);

    int insertSelective(ContentPropelling record);

    List<ContentPropelling> selectByExample(ContentPropellingExample example);

    ContentPropelling selectByPrimaryKey(ContentPropellingKey key);

    int updateByExampleSelective(@Param("record") ContentPropelling record, @Param("example") ContentPropellingExample example);

    int updateByExample(@Param("record") ContentPropelling record, @Param("example") ContentPropellingExample example);

    int updateByPrimaryKeySelective(ContentPropelling record);

    int updateByPrimaryKey(ContentPropelling record);
}