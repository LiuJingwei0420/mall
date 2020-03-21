package com.jx.mall.contorller;

import com.jx.mall.consts.MallConst;
import com.jx.mall.form.UserLoginForm;
import com.jx.mall.form.UserRegisterForm;
import com.jx.mall.pojo.User;
import com.jx.mall.service.IUserService;
import com.jx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

import static com.jx.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    //x-www-form-urlencoded
  /*  @PostMapping("/register")
    public void register(@RequestParam(value = "username") String username) {
        log.info("username={}", username);*/

  //raw json
        @PostMapping("/register")
        public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm,
                                   BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                log.error("注册提交的参数有误, {} {}",
                        Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                        bindingResult.getFieldError().getDefaultMessage());
                return ResponseVo.error(PARAM_ERROR,bindingResult);
            }

            User user = new User();
            BeanUtils.copyProperties(userForm, user);

           return userService.register(user);

        }

        @PostMapping("/login")
        public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                      BindingResult bindingResult,
                                      HttpSession session) {
            if (bindingResult.hasErrors()) {
                return ResponseVo.error(PARAM_ERROR,bindingResult);
            }

            ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

           //设置Session
            session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());

            return userResponseVo;
        }
}
