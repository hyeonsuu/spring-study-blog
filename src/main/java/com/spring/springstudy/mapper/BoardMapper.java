package com.spring.springstudy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    public List<Map<String,Object>> selectList();
}
