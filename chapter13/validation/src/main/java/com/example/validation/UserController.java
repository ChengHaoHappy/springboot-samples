package com.example.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By ChengHao On 2020/1/21
 */
@RestController
public class UserController {

    /**
     *
     * @param user
     * @param result 校验出错时保存的出错信息
     * @return
     */
    @PostMapping("/user")
    public List<String> addUser(@Validated User user, BindingResult result) {
        List<String> errors = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errors.add(error.getDefaultMessage());
            }
        }
        return errors;
    }
}
