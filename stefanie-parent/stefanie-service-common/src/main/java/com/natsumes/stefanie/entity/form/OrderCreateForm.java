package com.natsumes.stefanie.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;

    private Integer productNum;

    private Integer productId;

    private Integer createType;  // 1 - by product method

}
