package com.example.hanteoproject2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CateBoardDTO {
    private String cateName;
    private List<Board> boardList = new ArrayList<>();
    private List<CateBoardDTO> child;

    public CateBoardDTO(Cate cate) {
        this.cateName = cate.getName();
        this.child = cate.getChild().stream().map(o->new CateBoardDTO(o)).collect(Collectors.toList());
        for (CateBoard cb : cate.getCateBoards()){
            this.boardList.add(cb.getBoard());
            cb.getBoard().getName();
        }
    }
}
