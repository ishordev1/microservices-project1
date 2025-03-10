package com.QuizService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizService.Entity.Quiz;
import com.QuizService.Service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
private QuizService quizService;

@PostMapping
public Quiz save(@RequestBody Quiz quiz) {
	return this.quizService.add(quiz);
}
@GetMapping
public List<Quiz> getAll(){
	return this.quizService.get();
}

@GetMapping("/{id}")
public Quiz get(@PathVariable Long id) {
	return this.quizService.get(id);
}
}
