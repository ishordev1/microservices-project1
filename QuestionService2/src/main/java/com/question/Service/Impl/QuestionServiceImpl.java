package com.question.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.Entity.Question;
import com.question.Repository.QuestionRepository;
import com.question.Service.QuestionService;

@Service
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question add(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question get(Long id) {

		return this.questionRepository.findById(id).orElseThrow(()->new RuntimeException("question not found on this id."));
	}

	@Override
	public List<Question> get() {
		
		return this.questionRepository.findAll();
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		
		return this.questionRepository.findByQuizId(quizId);
	}

}
