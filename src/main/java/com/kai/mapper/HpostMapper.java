package com.kai.mapper;

import com.kai.pojo.Hpost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface HpostMapper {

    List<Hpost> getHpostList();

    Hpost getHpostById(int hid);

    Hpost getHpostByAid(int aid);

    int newHpost(Hpost hpost);

    int upHpost(Hpost hpost);

    int deletHpost(int hid);



}
