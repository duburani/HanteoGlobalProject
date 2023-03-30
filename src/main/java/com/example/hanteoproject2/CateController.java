package com.example.hanteoproject2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CateController {

    private final CateRepository cateRepository;

    @PostMapping("/category")
    public ResponseEntity<?> category(@RequestBody @Valid Cate cate){
        Long id = null;
        String name = null;
        if(cate != null){
            id = cate.getId() == null ? null : cate.getId();
            name = cate.getName() == null ? null : cate.getName();
        }

        List<CateBoardDTO> cateBoardDTOList = cateRepository.findAll_Querydsl(id, name).stream().map(c->new CateBoardDTO(c)).collect(Collectors.toList());
        return ResponseEntity.ok(cateBoardDTOList);
    }

}