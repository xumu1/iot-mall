package edu.ustc.iot.pojo;

import edu.ustc.iot.pojo.component.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述：方案
 *
 * @Author: xumu
 * @Date: 2020-5-16 18:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {
  private Integer id;
  private String name;
  private Integer uid;
  private  Integer isPublic;
  private  String intros;
  private List<Component> componentList;
}
