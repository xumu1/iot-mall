package edu.ustc.iot.controller;

import edu.ustc.iot.consts.MallConst;
import edu.ustc.iot.form.UserLoginForm;
import edu.ustc.iot.form.UserRegisterForm;
import edu.ustc.iot.pojo.User;
import edu.ustc.iot.service.IUserSerivce;
import edu.ustc.iot.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserSerivce userSerivce;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm){
        log.info("username:"+ userRegisterForm.getUsername());

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userSerivce.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo login(@Valid @RequestBody UserLoginForm userLoginForm,
                            HttpServletRequest httpServletRequest){
        ResponseVo<User> userResponseVo = userSerivce.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        //设置session，保存在内存中，也可保存到redis中
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login,sessionId={}",session.getId());

        return userResponseVo;
    }


    //TODO 判断登录状态
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout,sessionId={}",session.getId());

        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("success");
        return "success";
    }
}
