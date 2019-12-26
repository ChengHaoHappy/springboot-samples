package org.sang.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * @description: 全局异常处理
 * @author: chenghao
 * @date: 2019/9/6
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e) {
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error", e.getMessage());
        return mv;
    }
}
