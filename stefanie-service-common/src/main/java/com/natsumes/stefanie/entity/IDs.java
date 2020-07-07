package com.natsumes.stefanie.entity;

import com.natsumes.stefanie.pojo.Achievement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IDs implements Serializable {
    private static final long serialVersionUID = -8412635707783201268L;
    private Integer id;

    private Integer parentId;

    private List<IDs> subIDVos;

    private Boolean level;

    private Achievement achievement;
}
