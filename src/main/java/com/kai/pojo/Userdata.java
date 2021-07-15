package com.kai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userdata {
    private int dataid;
    private int uid;
    private String phone;
    private String email;
    private String gender;
    private String img;
    private String autograph;
}
