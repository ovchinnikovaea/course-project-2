package pro.sky.java.course2.courseproject2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.courseproject2.Question;
import pro.sky.java.course2.courseproject2.exception.NotEnoughQuestionException;
import pro.sky.java.course2.courseproject2.impl.ExaminerServiceImpl;
import pro.sky.java.course2.courseproject2.impl.JavaQuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    @ExtendWith(MockitoExtension.class)
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void sholdThrowNotEnoughQuestionExceptionWhenQuestionsAreNotEnough() {
        //given
        int amount = 5;
        Collection<Question> examinerQuestions = new HashSet<>() {{
            add(new Question("Question1", "Answer1"));
            add(new Question("Question2", "Answer2"));
            add(new Question("Question3", "Answer3"));
        }};

        when(javaQuestionService.getAll()).thenReturn(examinerQuestions);
        //when
        //then
        assertThrows(NotEnoughQuestionException.class, () ->
                examinerService.getQuestion(amount));

    }

    @Test
    public void shouldCorrectlyReturnNeedAmountQuestions() {
        //given
        int amount = 2;
        List<Question> examinerQuestions = List.of(
            new Question("Question1", "Answer1"),
            new Question("Question2", "Answer2"),
            new Question("Question3", "Answer3")
        );

        when(javaQuestionService.getAll()).thenReturn(examinerQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                examinerQuestions.get(0),
                examinerQuestions.get(0),
                examinerQuestions.get(1),
                examinerQuestions.get(1),
                examinerQuestions.get(2),
                examinerQuestions.get(2)
        );

        Set<Question> expectedQuestions = Set.of(examinerQuestions.get(0), examinerQuestions.get(1));

        //when
        Collection<Question> actualQuestions = examinerService.getQuestion(amount);

        //then
        Assertions.assertIterableEquals(expectedQuestions, actualQuestions);

    }

}
