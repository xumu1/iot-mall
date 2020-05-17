package edu.ustc.iot.enums;

import lombok.Getter;

/**
 * 角色0-管理员，1-普通用户
 */
@Getter
public enum RoleEnum {
    //顾客
    CUSTOMER(1),
    //管理员
    ADMIN(0),
    ;

    private int code;

    RoleEnum(int code) {
        this.code = code;
    }
}
