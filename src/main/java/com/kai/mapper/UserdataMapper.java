package com.kai.mapper;

import com.kai.pojo.Userdata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface UserdataMapper {

    List<Userdata> userdatalist();

    Userdata getUserdataBydataid(int dataid);

    Userdata getUserdataByuid(int uid);

    int newUserdata(Userdata userdata);

    int upUserdata(Userdata userdata);

    int deleteUserdata(int dataid);


}
