package com.example.capstone3.Repository;

import com.example.capstone3.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
Feedback findFeedbackById (Integer id);
}