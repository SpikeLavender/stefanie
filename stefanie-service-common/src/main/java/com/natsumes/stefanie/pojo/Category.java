package com.natsumes.stefanie.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 6214151371173076844L;
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;
}