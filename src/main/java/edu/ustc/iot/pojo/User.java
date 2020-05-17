package edu.ustc.iot.pojo;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-15 21:52
 */
@Data
public class User {
  private Integer id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private Integer company;
  //新增字段，判断是否是管理员
  private Integer role;

}
