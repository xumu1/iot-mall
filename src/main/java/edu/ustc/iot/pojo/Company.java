package edu.ustc.iot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：公司
 *
 * @Author: xumu
 * @Date: 2020-5-16 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
  private Integer id;
  private String name;
  private String address;
  private String industry;
  private String intros;
}
