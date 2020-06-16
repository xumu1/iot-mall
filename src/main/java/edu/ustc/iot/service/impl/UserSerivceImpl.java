package edu.ustc.iot.service.impl;


import edu.ustc.iot.dao.CompanyMapper;
import edu.ustc.iot.dao.UserMapper;
import edu.ustc.iot.pojo.Company;
import edu.ustc.iot.pojo.enums.ResponseEnum;
import edu.ustc.iot.pojo.enums.RoleEnum;
import edu.ustc.iot.pojo.User;
import edu.ustc.iot.pojo.vo.reponse.UserResponse;
import edu.ustc.iot.service.IUserSerivce;
import edu.ustc.iot.pojo.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserSerivceImpl implements IUserSerivce {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @Autowired
    @SuppressWarnings("all")
    private CompanyMapper companyMapper;

    @Override
    public ResponseVo<User> register(User user) {
        //校验 用户名，邮箱不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if(countByUsername>0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if(countByEmail>0){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }
        user.setRole(RoleEnum.CUSTOMER.getCode());
        //md5加密（Spring自带）
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        //写入数据库
        int resultConut = userMapper.insertSelective(user);
        if(resultConut==0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();

    }

    @Override
    public ResponseVo<UserResponse> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null){
            //用户不存在(返回：用户名或密码错误)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if(!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(
                password.getBytes(StandardCharsets.UTF_8)))){
            //密码错误(返回：用户名或密码错误)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        // 根据user的companyid查询company封装进userResponse中
        Company company = companyMapper.selectByPrimaryKey(user.getCompany());
        userResponse.setCompany(company);
        return ResponseVo.success(userResponse);
    }

}
