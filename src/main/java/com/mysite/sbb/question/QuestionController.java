package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class QuestionController {
    public final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    @ResponseBody
    public String list(){
        List<Question> quests = questionRepository.findAll();

        String questLiHtml = quests
                .stream()
                .map(q ->
                        "<li>%d / %s</li>"
                        .formatted(q.getId(), q.getSubject())
                ).collect(Collectors.joining("\n\t\t"));

        return """
                <!DOCTYPE HTML>
                <html lang=ko>
                <head>
                    <meta charset="UTF-8">
                    <title>질문 목록</title>
                </head>
                <body>
                    <h1>질문 목록</h1>
                    <ul>
                        %s
                    </ul>
                </body>
                """.formatted(questLiHtml);
    }
}
