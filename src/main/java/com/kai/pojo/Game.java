package com.kai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private int g_id;
    private String g_name;
    private String g_title;
    private String g_time;
    private String develop;
    private String publisher;
}
