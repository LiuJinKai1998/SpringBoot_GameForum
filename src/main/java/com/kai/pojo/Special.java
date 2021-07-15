package com.kai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Special {
    private int sid;
    private int aid;
    private String spectitle;
    private String speccont;
    private String specimg;
}
