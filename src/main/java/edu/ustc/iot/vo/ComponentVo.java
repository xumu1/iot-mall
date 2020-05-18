package edu.ustc.iot.vo;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 15:10
 */
@Data
public class ComponentVo {
  private Integer id;
  private String name;
  private Integer type;
  private Integer company;
  private String description;
}
