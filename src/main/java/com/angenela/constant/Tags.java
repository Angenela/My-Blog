package com.angenela.constant;

import com.angenela.dao.Tag;

import java.util.List;

public class Tags {
    private static List<Tag> tags;

    public static List<Tag> getTags() {
        return tags;
    }

    public static void setTags(List<Tag> tags) {
        Tags.tags = tags;
    }

    public static void add(Tag tag){
        tags.add(tag);
    }

    public static void addCountById(Integer id){
        Tag tagById = getTagById(id);
        tagById.setCount(tagById.getCount()+1);
    }

    public static void addCountByName(String name){
        Tag tagById = getTagByName(name);
        tagById.setCount(tagById.getCount()+1);
    }

    public static Tag getTagById(Integer id){
        for (Tag tag : tags) {
            if(tag.getId().equals(id)){
                return tag;
            }
        }
        return null;
    }

    public static Tag getTagByName(String name){
        for (Tag tag : tags) {
            if(tag.getName().equals(name)){
                return tag;
            }
        }
        return null;
    }
}
