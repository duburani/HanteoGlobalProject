package com.example.hanteoproject2;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Cate parent;

    @OneToMany(mappedBy = "parent")
    private List<Cate> child = new ArrayList<>();

    @OneToMany(mappedBy = "cate")
    private List<CateBoard> cateBoards = new ArrayList();

    public void addChildCategory(Cate child){
        this.child.add(child);
        child.setParent(this);
    }
}