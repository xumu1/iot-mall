package edu.ustc.iot.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class zi extends fu {
    private String ziName;

    public zi(String ziName){
        this.ziName = ziName;
    }

}
