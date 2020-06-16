package edu.ustc.iot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：用户
 *
 * @Author: xumu
 * @Date: 2020-5-15 21:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
