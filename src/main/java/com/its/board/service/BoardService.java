package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.entity.BoardEntity;
import com.its.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public Long save(BoardDTO boardDTO) {
        Long savedId = boardRepository.save(BoardEntity.toSaveEntity(boardDTO)).getBoardId();
        return savedId;
    }

    public List<BoardDTO> findAll(){
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity board: boardEntityList) {
            BoardDTO boardDTO = BoardDTO.toDTO(board);
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }
    public BoardDTO findById(Long boardId) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(boardId);
        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity = optionalBoardEntity.get();
            return BoardDTO.toDTO(boardEntity);
        }
        return null;
    }
}
