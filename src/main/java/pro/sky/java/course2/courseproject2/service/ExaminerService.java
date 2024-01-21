package pro.sky.java.course2.courseproject2.service;

import pro.sky.java.course2.courseproject2.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
