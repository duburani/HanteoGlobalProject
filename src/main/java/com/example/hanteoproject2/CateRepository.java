package com.example.hanteoproject2;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CateRepository extends QuerydslRepositorySupport{
    private final JPAQueryFactory queryFactory;

    private final QCate qCate;
    private final QCateBoard qCateBoard;

    public CateRepository(EntityManager em, JPAQueryFactory queryFactory){
        super(Cate.class);
        this.queryFactory = queryFactory;
        this.qCate = QCate.cate;
        this.qCateBoard = QCateBoard.cateBoard;
    }

    public List<Cate> findAll_Querydsl(Long id, String name){
        return queryFactory
                .selectDistinct(qCate)
                .from(qCate)
                .leftJoin(qCate.cateBoards, qCateBoard).fetchJoin()
                .where(
                        parentNull(id, name),
                        idEq(id),
                        nameEq(name)
                )
                .fetch()
                ;
    }

    private BooleanExpression idEq(Long id){
        return id != null ? qCate.id.eq(id): null;
    }
    private BooleanExpression nameEq(String name){
        return StringUtils.hasText(name) ? qCate.name.eq(name) : null;
    }
    private BooleanExpression parentNull(Long id, String name){
        return id == null && !StringUtils.hasText(name) ? qCate.parent.isNull() : null;
    }

}