package com.natsumes.stefanie.enums;

import lombok.Getter;

@Getter
public enum GrantTypeEnum {

    WX("wx_user_code_check"),

    NORMAL("username_name_check");

    private String type;

    GrantTypeEnum(String type) {
        this.type = type;
    }
}
