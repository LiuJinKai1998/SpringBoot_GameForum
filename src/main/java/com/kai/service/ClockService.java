package com.kai.service;

import com.kai.mapper.ClockMapper;
import com.kai.pojo.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockService {

    @Autowired
    private ClockMapper clockMapper;

    public List<Clock> getClockList() {
        return clockMapper.getClockList();
    }

    public Clock getClockById(int id){
        return clockMapper.getClockById(id);
    }

    public int newClock(Clock clock){
        return clockMapper.newClock(clock);
    }

    public int upClock(Clock clock) {

        return clockMapper.upClock(clock);
    }

    public int deleteClock(Integer id) {
        return clockMapper.deleteClock(id); }


}
