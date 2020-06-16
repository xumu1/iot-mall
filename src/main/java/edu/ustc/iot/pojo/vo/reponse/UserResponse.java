package edu.ustc.iot.pojo.vo.reponse;

import edu.ustc.iot.pojo.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
//    private Integer company;
    private Company company;
    //新增字段，判断是否是管理员
    private Integer role;
}
