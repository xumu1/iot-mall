package edu.ustc.iot.pojo;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-16 18:37
 */
@Data
public class Program {
  private Integer id;
  private String name;
  private Integer uid;
  private  Integer isPublic;
  private  String intros;
}
