package com.natsumes.stefanie.entity.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentForm {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer productId;

    private String username;

    @NotBlank
    private String content;

    private Integer giveLike;

    private Integer status;

    private Integer replyId;

    private Integer role;
}
