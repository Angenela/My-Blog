package com.angenela.service.tag;

import com.angenela.dao.Tag;

import java.util.List;


public interface TagService {
    Tag getTagByName(String name);

    List<Tag> getAll();

    void add(Tag tag);

    void addCountById(Integer id);
}
