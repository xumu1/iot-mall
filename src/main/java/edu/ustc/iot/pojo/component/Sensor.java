package edu.ustc.iot.pojo.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传感器
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor extends Component{
    private Integer id;
    private String name;            //产品名称
    private String model;           //产品型号
    private Double frequencyBand;   //工作频段
    private Double lowTemperature;  //工作温度(℃）
    private Double highTemperature; //工作温度(℃）
    private Double speed;           //射频数据传输速率 kb/s
    private Double lowVoltage;      //供电电压（V)
    private Double highVoltage;     //供电电压（V)
    private Double electric;        //供电电流（mA）
    private Integer company;        //厂商
    private String interfaceDesc;   //接口特性
    private String desc;            //产品特点

}
