package com.kai.service;

import com.kai.mapper.SpecialMapper;
import com.kai.pojo.Special;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

    public List<Special> getSpecialList() {
        return specialMapper.getSpecialList();
    }

    public Special getSpecialById(int id){
        return specialMapper.getSpecialById(id);
    }

    public int newSpecial(Special special){
        return specialMapper.newSpecial(special);
    }

    public int upSpecial(Special special) {
        return specialMapper.upSpecial(special);
    }

    public int deleteSpecial(Integer id) {
        return specialMapper.deleteSpecial(id);
    }


}
