package com.kai.mapper;

import com.kai.pojo.Special;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface SpecialMapper {

    //查询全部信息
    List<Special> getSpecialList();

    //根据id查询信息
    Special getSpecialById(int id);

    int newSpecial(Special special);

    int upSpecial(Special special);

    int deleteSpecial(int id);


}
