package com.board.hello_springboot.repository;

import com.board.hello_springboot.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 조회수 증가 MySQL = update board_table set board_hits=board_hits+1 where id=?
    @Modifying // update, delete 쿼리 실행해야할 때 필수로 붙어야함
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);
}
