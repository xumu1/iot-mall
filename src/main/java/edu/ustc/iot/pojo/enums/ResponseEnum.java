package edu.ustc.iot.pojo.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    SUCCESS(0,"成功"),

    PASSWORD_ERROR(1,"密码错误"),

    USERNAME_EXIST(2,"用户名已存在"),

    NEED_LOGIN(10,"用户未登录，请先登录"),

    PARAM_ERROR(3,"参数错误"),

    EMAIL_EXIST(4,"邮箱已存在"),

    ERROR(-1,"服务端错误"),

    USERNAME_OR_PASSWORD_ERROR(11, "用户名或者密码错误"),

    DELETE_ERROR(5,"删除失败"),

    INSERT_ERROR(6,"添加失败"),

    UPDATE_ERROR(7,"更新失败")

    ;
    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
