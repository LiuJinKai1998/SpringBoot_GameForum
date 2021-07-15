package com.kai.mapper;

import com.kai.pojo.Section;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface SectionMapper {

    //查询全部信息
    List<Section> getSectionList();

    //根据id查询信息
    Section getSectionById(int id);

    int newSection(Section section);

    int upSection(Section section);

    int deleteSection(int id);


}
