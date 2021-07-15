package com.kai.service;

import com.kai.mapper.UserdataMapper;
import com.kai.pojo.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserdataService {

    @Autowired
    private UserdataMapper userdataMapper;

    public List<Userdata> userdatalist() {
        return userdataMapper.userdatalist();
    }

    public Userdata getUserdataBydataid(int dataid) {
        return userdataMapper.getUserdataBydataid(dataid);
    }

    public Userdata getUserdataByuid(int uid) {
        return userdataMapper.getUserdataByuid(uid);
    }

    public int newUserdata(Userdata userdata){
        return userdataMapper.newUserdata(userdata);
    }

    public int upUserdata(Userdata userdata) {

        return userdataMapper.upUserdata(userdata);
    }

    public int deleteUserdata(int dataid) {
        return userdataMapper.deleteUserdata(dataid);
    }


}
