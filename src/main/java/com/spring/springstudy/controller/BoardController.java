package com.spring.springstudy.controller;

import com.google.gson.Gson;
import com.spring.springstudy.VO.Result;
import com.spring.springstudy.common.CommonCode;
import com.spring.springstudy.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/board_main", method = {RequestMethod.GET})
    public ModelAndView boardMain(@RequestParam Map<String, Object> param, HttpServletRequest req, HttpServletResponse res){
        ModelAndView mav = new ModelAndView();
        mav.addObject("viewName", "board");
        mav.setViewName("board/board_main");
        return mav;
    }

    @RequestMapping(value = "/board_insert", method = {RequestMethod.GET})
    public ModelAndView boardInsert(@RequestParam Map<String, Object> param, HttpServletRequest req, HttpServletResponse res){
        ModelAndView mav = new ModelAndView();
        mav.addObject("viewName", "board");
        mav.setViewName("board/board_insert");
        return mav;
    }

    @RequestMapping(value = "/board_update", method = {RequestMethod.GET})
    public ModelAndView boardUpdate(@RequestParam Map<String, Object> param, HttpServletRequest req, HttpServletResponse res){
        ModelAndView mav = new ModelAndView();
        mav.addObject("viewName", "board");
        mav.setViewName("board/board_update");
        return mav;
    }

    @RequestMapping(value = "/selectList", method = {RequestMethod.POST})
    public ResponseEntity<String> selectList(HttpServletRequest req, HttpServletResponse res){
        Result result = new Result();

        try {
            List<Map<String,Object>> selectList = boardService.selectList();
            result.setData("selectList", selectList);
        } catch (Exception e) {
            log.debug("error : " + e.getMessage());
            e.printStackTrace();
            result = new Result(CommonCode.ERROR_OTHER);
        }
        return ResponseEntity.ok(gson.toJson(result));
    }

    @RequestMapping(value = "/insertBoardList", method = {RequestMethod.POST})
    public ResponseEntity<String> insertBoardList(@RequestParam Map<String, Object> param, HttpServletRequest req, HttpServletResponse res){
        Result result = new Result();

        try {
            boardService.insertBoardList(param);
        } catch (Exception e) {
            log.debug("error : " + e.getMessage());
            e.printStackTrace();
            result = new Result(CommonCode.ERROR_OTHER);
        }
        return ResponseEntity.ok(gson.toJson(result));
    }
}
