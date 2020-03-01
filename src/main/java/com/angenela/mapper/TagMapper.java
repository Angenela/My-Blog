package com.angenela.mapper;

import com.angenela.dao.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    Tag getTagByName(String name);

    List<Tag> getAll();

    void addTag(Tag tag);

    void addCountById(Integer id);

    void addCountByName(String name);
}
