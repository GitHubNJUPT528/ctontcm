package com.cton.model;

import java.io.Serializable;
import lombok.Data;

/**
 * u_user
 * @author
 */
@Data
public class UserKey implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}
