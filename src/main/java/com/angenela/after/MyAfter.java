package com.angenela.after;

import com.angenela.constant.Tags;
import com.angenela.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAfter implements ApplicationRunner {

    @Autowired
    private TagService tagService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Tags.setTags(tagService.getAll());
    }
}
