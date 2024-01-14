package pro.sky.java.course2.courseproject2.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.courseproject2.Question;
import pro.sky.java.course2.courseproject2.exception.NotEnoughQuestionException;
import pro.sky.java.course2.courseproject2.service.ExaminerService;
import pro.sky.java.course2.courseproject2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> examinerQuestion = new HashSet<>();

        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionException("Недостаточно вопросов");
        }

        while (examinerQuestion.size() < amount) {
            examinerQuestion.add(questionService.getRandomQuestion());
        }

        return examinerQuestion;
    }
}
