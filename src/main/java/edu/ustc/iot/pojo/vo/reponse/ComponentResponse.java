package edu.ustc.iot.pojo.vo.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentResponse {
    private Integer id;
    private String name;
    private Integer type;
    private Integer company;
    private String description;
}
