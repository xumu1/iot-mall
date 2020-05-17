package edu.ustc.iot.pojo;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-16 18:35
 */
@Data
public class Company {
  private Integer id;
  private String name;
  private String address;
  private String industry;
  private String intros;
}
