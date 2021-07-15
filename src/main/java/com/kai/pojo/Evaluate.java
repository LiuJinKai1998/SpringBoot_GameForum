package com.kai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluate {
    private int eid;
    private int g_id;
    private int uid;
    private String fraction;
    private String econtent;
    private String gamestate;
}
