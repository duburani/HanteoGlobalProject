package com.example.hanteoproject2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id @GeneratedValue
    @Column(name="board_id")
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "board")
    private List<CateBoard> cateBoards = new ArrayList<>();
}
