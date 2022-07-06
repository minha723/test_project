package com.its.board.test;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestClass {

    @Autowired
    private BoardService bs;

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("save test")
    public void saveTest(){
        String testTitle ="테스트제목";
        String testWriter = "테스트작성자";
        String testContents = "테스트내용";
        BoardDTO board = new BoardDTO(testTitle, testWriter, testContents);
        Long id = bs.save(board);
        BoardDTO findBoard = bs.findById(id);
        String boardWriter = findBoard.getBoardWriter();
        assertThat(testWriter).isEqualTo(boardWriter);
    }

}
