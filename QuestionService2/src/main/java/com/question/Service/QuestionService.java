package com.question.Service;

import java.util.List;

import com.question.Entity.Question;

public interface QuestionService {
Question add(Question question);
Question get(Long id);
List<Question> get();
List<Question> getQuestionOfQuiz(Long quizId);
}
