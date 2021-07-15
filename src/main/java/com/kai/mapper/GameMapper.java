package com.kai.mapper;

import com.kai.pojo.Game;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface GameMapper {

    //查询全部信息
    List<Game> getGameList();

    //根据id查询信息
    Game getGameById(int id);

    int newGame(Game game);

    int updateGame(Game game);

    int deleteGame(int id);


}
