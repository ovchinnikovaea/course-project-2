package pro.sky.java.course2.courseproject2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.courseproject2.Question;
import pro.sky.java.course2.courseproject2.impl.JavaQuestionService;

import java.util.*;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    private Question question;

    @BeforeEach
    public void setUp() {
        question = new Question("Question", "Answer");
    }

    @Test
    public void shouldCorrectlyAddQuestionWithAnswer() {
        //given
        Question excpectedQuestion = question;
        //when
        Question actualQuestion = javaQuestionService.add(question.getQuestion(), question.getAnswer());
        //then
        Assertions.assertEquals(excpectedQuestion, actualQuestion);
    }

    @Test
    public void shouldCorrectlyAddQuestion() {
        //given
        Question excpectedQuestion = question;
        //when
        Question actualQuestion = javaQuestionService.add(question);
        //then
        Assertions.assertEquals(excpectedQuestion, actualQuestion);
    }

    @Test
    public void shouldCorrectlyReturnRemovedQuestion() {
        //given
        javaQuestionService.add(question);
        //when
        Question actualQuestion = javaQuestionService.remove(question);
        //then
        Assertions.assertEquals(question, actualQuestion);
    }

    @Test
    public void shouldCorrectlyReturnAllQuestions() {
        //given
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");

            javaQuestionService.add(question1);
            javaQuestionService.add(question2);

        //when
        Collection<Question> actualQuestions = javaQuestionService.getAll();
        //then
        Assertions.assertIterableEquals(List.of(question1, question2), actualQuestions);
    }

    @Test
    public void shouldCorrectlyReturnRandomQuestion() {
        //given
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        //when
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        //then
        Assertions.assertTrue(List.of(question1, question2).contains(randomQuestion));
    }
}
