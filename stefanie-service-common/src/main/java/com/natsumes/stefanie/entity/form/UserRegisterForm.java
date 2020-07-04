package com.natsumes.stefanie.entity.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {

    //@NotBlank 用于 String 判断空格
    //@NotEmpty 用于集合
    //@NotNull
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Integer parentId;
}
