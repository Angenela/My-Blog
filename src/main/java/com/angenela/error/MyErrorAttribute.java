package com.angenela.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map errorMap = super.getErrorAttributes(webRequest, includeStackTrace);

        if ((Integer) errorMap.get("status") == 404) {
            errorMap.put("message", "页面不存在");
        } else if ((Integer) errorMap.get("status") == 500) {
            errorMap.put("message", "服务器内部错误");
        }

        return errorMap;
    }
}
