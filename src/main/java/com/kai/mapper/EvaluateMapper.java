package com.kai.mapper;

import com.kai.pojo.Evaluate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface EvaluateMapper {

    //查询全部信息
    List<Evaluate> getEvaluateList();

    //根据id查询信息
    Evaluate getEvaluateById(int id);

    int newEvaluate(Evaluate evaluate);

    int upEvaluate(Evaluate evaluate);

    int deleteEvaluate(int id);


}
