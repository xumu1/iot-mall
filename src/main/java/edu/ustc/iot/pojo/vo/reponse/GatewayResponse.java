package edu.ustc.iot.pojo.vo.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayResponse extends ComponentResponse{
    private String model;               //型号
    private String innerProtocols;      //物联网设备间协议
    private String uploadProtocols;     //物联网设备上传协议
    private String industrialGrade;     //物联网设备的应用场所类型
    private Integer chargeable;         //可充电电池与否
    private Double lowVoltage;         //供电电压（V)
    private Double highVoltage;        //供电电压（V)
    private Double lowTemperature;     //工作温度(℃）
    private Double highTemperature;    //工作温度(℃）
    private String desc;                //描述
    private String otherDesc;
}
