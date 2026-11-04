package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDateTime createDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    //mappedBy 속성을 지정하지 않으면 미련하게 별개의 중간 테이블을 만든다.
    private List<Answer> answers;
}