package com.angenela.error;

import com.angenela.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MyException.class)
    public ModelAndView userNoExist() {

        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, Object> model = modelAndView.getModel();
        model.put("msg", "服务器异常");

        return modelAndView;
    }

}
