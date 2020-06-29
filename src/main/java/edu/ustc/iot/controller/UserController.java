package edu.ustc.iot.controller;

import edu.ustc.iot.consts.MallConst;
import edu.ustc.iot.pojo.vo.request.form.UserLoginForm;
import edu.ustc.iot.pojo.vo.request.form.UserRegisterForm;
import edu.ustc.iot.pojo.User;
import edu.ustc.iot.pojo.vo.reponse.UserResponse;
import edu.ustc.iot.service.IUserSerivce;
import edu.ustc.iot.pojo.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("api")
@Slf4j
public class UserController {

    @Autowired
    private IUserSerivce userSerivce;

    // 注册
    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm){
        log.info("username:"+ userRegisterForm.getUsername());

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userSerivce.register(user);
    }

    // 登录
    @PostMapping("/user/login")
    public ResponseVo login(@Valid @RequestBody UserLoginForm userLoginForm,
                            HttpServletRequest httpServletRequest){
        ResponseVo<UserResponse> userResponseVo = userSerivce.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        //设置session，保存在内存中，也可保存到redis中
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login,sessionId={}",session.getId());

        return userResponseVo;
    }


    // 登出
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout,sessionId={}",session.getId());

        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }


}
