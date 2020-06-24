package edu.ustc.iot.pojo.vo.request.form;

import edu.ustc.iot.pojo.component.Component;
import lombok.Data;

@Data
public class ComponentForm {
    private Integer type;
    private Integer pageNum;
    private Integer pageSize;
    private Component component;
}
