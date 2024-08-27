package com.board.hello_springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AutoCloseable.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 생성됐을 때 시간을 만들어주는 부분
    @Column(updatable = false) // 수정시에는 관여를 안함
    private LocalDateTime createdTime;

    @UpdateTimestamp // 업데이트가 발생했을 때 시간정보를 줌
    @Column(insertable = false) // 생성됐을때 관여를 안함
    private LocalDateTime updatedTime;
}
