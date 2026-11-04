package com.mysite.sbb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("findAll")
    void t1() {
        List<Question> all = questionRepository.findAll();
        assertThat(all.get(1).getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("findById")
    void t2(){
        Question q = questionRepository.findById(1).get();
        assertThat(q.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("findBySubject")
    void t3(){
        Question q = questionRepository.findBySubject("질문이요").get();
        assertThat(q.getSubject()).isEqualTo("질문이요");
    }

    @Test
    @DisplayName("findBySubjectAndContent")
    void t4(){
        Question q = questionRepository.findBySubjectAndContent("질문이요", "").orElse(null);
        assertThat(q).isNull();
    }
}
