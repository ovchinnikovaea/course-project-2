package pro.sky.java.course2.courseproject2.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.courseproject2.Question;
import pro.sky.java.course2.courseproject2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        add(new Question("Что такое переменная?", "Область в памяти компьютера для хранения данных, которой можно присвоить имя"));
        add(new Question("Назовите 3 принципа ООП", "Инкапсуляция, полиморфизм, наследование"));
        add(new Question("Что такое метод?", "Код, который решает определенную задачу и может использоваться много раз в разных местах"));
        add(new Question("Чем массив отличается от ArrayList?", "ArrayList можно увеличить, а массив — нет"));
    };

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        questions.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(questions.size());
        return new ArrayList<Question>(questions).get(number);
    }
}
