package com.example.capstone3.Repository;

import com.example.capstone3.Model.Contributor;
import com.example.capstone3.Model.Request;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {

    Request findRequestById(Integer id);

    List<Request> findRequestsByContributor(Contributor contributor);

    List<Request> findRequestsByDecisionAndContributor(@Pattern(regexp = "^(?i)(pending|accepted|rejected)$") String decision,Contributor contributor);
}
