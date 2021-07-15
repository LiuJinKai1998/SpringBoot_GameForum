package com.kai.service;

import com.kai.mapper.EvaluateMapper;
import com.kai.pojo.Evaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    public List<Evaluate> getEvaluateList() {
        return evaluateMapper.getEvaluateList();
    }

    public Evaluate getEvaluateById(int id) {
        return evaluateMapper.getEvaluateById(id);
    }

    public int newEvaluate(Evaluate evaluate){
        return evaluateMapper.newEvaluate(evaluate);
    }

    public int upEvaluate(Evaluate evaluate) {
        return evaluateMapper.upEvaluate(evaluate);
    }

    public int deleteEvaluate(Integer id) {
        return evaluateMapper.deleteEvaluate(id);
    }

}
