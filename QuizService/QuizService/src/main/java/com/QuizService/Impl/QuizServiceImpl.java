package com.QuizService.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizService.Entity.Quiz;
import com.QuizService.Repository.QuizRepository;
import com.QuizService.Service.QuestionClient;
import com.QuizService.Service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepo;
	
	//this impl not need openfeign automatic made
	@Autowired
	private QuestionClient questionClient;



	@Override
	public Quiz add(Quiz quiz) {
		return this.quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = this.quizRepo.findAll();
		List<Quiz> allQuizWithQuestion = quizzes.stream().map(quiz->{
			quiz.setQuestion(this.questionClient.getQuestionOfQuiz(quiz.getQuizId()));
			return quiz;
		}).collect(Collectors.toList());
		return allQuizWithQuestion;
	}
	
	@Override
	public Quiz get(Long id) {
	Quiz quiz=	this.quizRepo.findById(id).orElseThrow(() -> new RuntimeException("quiz not found in this id."));
		quiz.setQuestion(this.questionClient.getQuestionOfQuiz(id));
	
	return quiz;
	}

}
