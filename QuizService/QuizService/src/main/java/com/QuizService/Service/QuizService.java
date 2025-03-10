package com.QuizService.Service;

import java.util.List;

import com.QuizService.Entity.Quiz;

public interface QuizService {
Quiz get(Long id);
Quiz add(Quiz quiz);
List<Quiz> get();
}
