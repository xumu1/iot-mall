package edu.ustc.iot.service;


import edu.ustc.iot.pojo.User;
import edu.ustc.iot.pojo.vo.ResponseVo;
import edu.ustc.iot.pojo.vo.reponse.UserResponse;

public interface IUserSerivce {
    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登陆
     * @param
     */
    ResponseVo<UserResponse> login(String username, String password);

}
