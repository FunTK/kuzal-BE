package com.kuzal.kuzalcompetition.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3968600137588125697L;
    private String displayName;
    private String email;

}
