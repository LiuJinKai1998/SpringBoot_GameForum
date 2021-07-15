package com.kai.service;

import com.kai.mapper.HpostMapper;
import com.kai.pojo.Hpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HpostService {

    @Autowired
    private HpostMapper hpostMapper;



    public List<Hpost> getHpostList() {
        return hpostMapper.getHpostList();
    }

    public Hpost getHpostById(int hid) {
        return hpostMapper.getHpostById(hid);
    }

    public Hpost getHpostByAid(int aid) {
        return hpostMapper.getHpostByAid(aid);
    }

    public boolean newHpost(Hpost hpost){
        int res = hpostMapper.newHpost(hpost);
        if (res > 0) {
            return true;
        }
        return false;
    }

    public int upHpost(Hpost hpost) {

        return hpostMapper.upHpost(hpost);
    }

    public int deletHpost(Integer hid) {
        return hpostMapper.deletHpost(hid);
    }



}
