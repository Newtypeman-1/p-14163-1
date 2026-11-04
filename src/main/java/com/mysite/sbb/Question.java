package com.mysite.sbb;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDateTime createDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    //@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    @OneToMany(cascade = CascadeType.REMOVE) //글 삭제시 답변들도 삭제
    //mappedBy 속성을 지정하지 않으면 중간 테이블을 만든다.
    private List<Answer> answers;
}