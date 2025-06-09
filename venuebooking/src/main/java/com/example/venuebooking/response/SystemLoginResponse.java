package com.example.venuebooking.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemLoginResponse  implements Serializable {

    private Integer id;

    private String account;

    private String realName;

    private String Token;

}
