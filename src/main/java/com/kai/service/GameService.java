package com.kai.service;

import com.kai.mapper.GameMapper;
import com.kai.pojo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    public List<Game> getGameList() {
        return gameMapper.getGameList();
    }

    public Game getGameById(int id) {
        return gameMapper.getGameById(id);
    }



    public int newGame(Game game){
        return gameMapper.newGame(game);
    }

    public int updateGame(Game game) {

        return gameMapper.updateGame(game);
    }

    public int deleteGame(Integer id) {
        return gameMapper.deleteGame(id);
    }

}
