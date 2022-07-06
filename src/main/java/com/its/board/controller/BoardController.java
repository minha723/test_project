package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService bs;

    @PostMapping("/save")
    private String save(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        Long savedId = bs.save(boardDTO);
        return "redirect:/board/" ;
    }

    @GetMapping("/{boardId}")
    public String findById(@PathVariable Long boardId, Model model){
        BoardDTO boardDTO= bs.findById(boardId);
        model.addAttribute("board", boardDTO);
        return "detail";
    }
}