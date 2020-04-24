package com.liuchongyang;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Integer id;
    private String name;
    private String orderno;
    private String username;
}
