package com.spring.springstudy.service;

import com.spring.springstudy.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Map<String,Object>> selectList() {
        List<Map<String,Object>> selectList = boardMapper.selectList();
        return selectList;
    }

    public void insertBoardList(Map<String, Object> param) {
        boardMapper.insertBoardList(param);
    }



}
