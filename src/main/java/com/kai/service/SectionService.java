package com.kai.service;

import com.kai.mapper.SectionMapper;
import com.kai.pojo.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionMapper sectionMapper;

    public List<Section> getSectionList() {
        return sectionMapper.getSectionList();
    }

    public Section getSectionById(int id){
        return sectionMapper.getSectionById(id);
    }

    public int newSection(Section section){
        return sectionMapper.newSection(section);
    }

    public int upSection(Section section) {

        return sectionMapper.upSection(section);
    }

    public int deleteSection(Integer id) {
        return sectionMapper.deleteSection(id);
    }


}
