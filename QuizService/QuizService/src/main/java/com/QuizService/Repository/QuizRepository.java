package com.QuizService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizService.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
