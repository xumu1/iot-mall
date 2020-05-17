package edu.ustc.iot.service;


import edu.ustc.iot.pojo.User;
import edu.ustc.iot.vo.ResponseVo;

public interface IUserSerivce {
    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登陆
     * @param
     */
    ResponseVo<User> login(String username, String password);

}
