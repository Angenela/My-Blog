package com.angenela.controller.admin;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String imgLocation;
    @Value("${img.url}")
    private String url;

    @PostMapping(value = "/upload/image")
    public String demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap();

        String fileName = file.getOriginalFilename();
        fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf('.'));
        //保存
        try {
            File imageFolder = new File(FileController.class.getClassLoader().getResource(imgLocation).getPath());
            File targetFile = new File(imageFolder, fileName);
            if (!targetFile.getParentFile().exists())
                targetFile.getParentFile().mkdirs();
            file.transferTo(targetFile);

            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url", url + fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }

        return JSON.toJSONString(resultMap);
    }
}

