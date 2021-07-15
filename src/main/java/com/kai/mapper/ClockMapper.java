package com.kai.mapper;

import com.kai.pojo.Clock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface ClockMapper {

    //查询全部信息
    List<Clock> getClockList();

    //根据id查询信息
    Clock getClockById(int id);

    int newClock(Clock clock);

    int upClock(Clock clock);

    int deleteClock(int id);


}
