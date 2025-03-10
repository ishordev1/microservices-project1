package com.question.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Entity.Question;
import com.question.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
@Autowired
private QuestionService questionService;

@PostMapping
public Question add(@RequestBody Question question) {
	return this.questionService.add(question);
}


@GetMapping("/{id}")
public Question getQuestion(@PathVariable Long id) {
	return this.questionService.get(id);
}

@GetMapping
public List<Question> get(){
	return this.questionService.get();
}

@GetMapping("/quiz/{id}")
public List<Question> getQuestionOfQuiz(@PathVariable Long id){
	return this.questionService.getQuestionOfQuiz(id);
}



}
