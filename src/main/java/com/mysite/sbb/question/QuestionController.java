package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

//    @GetMapping("/question/listold")
//    public String list(Model model){
//        model.addAttribute("name", "paul");
//        model.addAttribute("ages", List.of(10, 20, 30, 40, 50));
//
//        return "question_list";
//    }

    @GetMapping("/question/list")
    public String list2(Model mod){
        List<Question> questions = questionService.getList();
        mod.addAttribute("questions", questions);

        return "question_list4";
    }

    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable Integer id){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }

//    @GetMapping("/question/list")
//    @ResponseBody
//    public String list(){
//        List<Question> quests = questionRepository.findAll();
//
//        String questLiHtml = quests
//                .stream()
//                .map(q ->
//                        "<li>%d / %s</li>"
//                        .formatted(q.getId(), q.getSubject())
//                ).collect(Collectors.joining("\n\t\t"));
//
//        return """
//                <!DOCTYPE HTML>
//                <html lang=ko>
//                <head>
//                    <meta charset="UTF-8">
//                    <title>질문 목록</title>
//                </head>
//                <body>
//                    <h1>질문 목록</h1>
//                    <ul>
//                        %s
//                    </ul>
//                </body>
//                """.formatted(questLiHtml);
//    }
}
