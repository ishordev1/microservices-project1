package com.QuizService.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.QuizService.Entity.Question;

//@FeignClient(url="http://localhost:8082", value="Question-client")
@FeignClient(name = "QUESTIONSERVICE")

public interface QuestionClient {
	@GetMapping("/question/quiz/{id}")
List<Question> getQuestionOfQuiz(@PathVariable Long id);
}
