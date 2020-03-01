package com.angenela.service.tag;

import com.angenela.dao.Tag;
import com.angenela.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> getAll() {
        return tagMapper.getAll();
    }

    @Override
    public void add(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public void addCountById(Integer id) {
        tagMapper.addCountById(id);
    }
}
