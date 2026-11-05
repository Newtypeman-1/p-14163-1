package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

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

    @Test
    @DisplayName("findBySubjectLike")
    void t5(){
        Question q = questionRepository.findBySubjectLike("질문%").get();
        assertThat(q).isNotNull();
    }

    @Test
    @DisplayName("수정")
    void t6(){

    }

    @Test
    @DisplayName("삭제")
    void t7(){

    }

    @Test
    @DisplayName("답변 생성")
    void t8(){

    }

    @Test
    @DisplayName("답변 생성 by oneToMany")
    void t9(){
        Question q = questionRepository.findById(2).get();

        int count = q.getAnswers().size();

        Answer a = q.addAnswer("네 자동 생성합니다");

        assertThat(a.getId()).isEqualTo(0);

        int afterCount = q.getAnswers().size();

        assertThat(afterCount).isEqualTo(count + 1);
    }

    @Test
    @DisplayName("답변 조회")
    void t10(){
        Answer a = answerRepository.findById(1).get();

        assertThat(a.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("답변 조회 by oneToMany")
    void t11(){
        Question q = questionRepository.findById(2).get();

        List<Answer> answers = q.getAnswers();
        assertThat(answers).hasSize(1);

        Answer a = answers.get(0);
        assertThat(a.getContent()).isEqualTo("네 자동으로 생성됩니다");
    }
}
