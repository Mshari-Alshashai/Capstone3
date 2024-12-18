package com.example.capstone3.Controller;

import com.example.capstone3.API.ApiResponse;
import com.example.capstone3.DTO.FeedbackDTO;
import com.example.capstone3.DTO.RequestIDTO;
import com.example.capstone3.DTO.ResearcherIDTO;
import com.example.capstone3.Service.ResearcherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/researcher")
@RequiredArgsConstructor
public class ResearcherController {

    private final ResearcherService researcherService;

    @GetMapping("/get")
    public ResponseEntity getAllResearchers(){
        return ResponseEntity.status(200).body(researcherService.getAllResearchers());
    }

    @PostMapping("/add")
    public ResponseEntity addResearcher(@RequestBody @Valid ResearcherIDTO researcherIDTO){
        researcherService.addResearcher(researcherIDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Researcher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateResearcher(@PathVariable Integer id,@RequestBody @Valid ResearcherIDTO researcherIDTO){
        researcherService.updateResearcher(id,researcherIDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Researcher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResearcher(@PathVariable Integer id){
        researcherService.deleteResearcher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Researcher deleted successfully"));
    }

    @PostMapping("/request-to-borrow-artifact/{researcher-id}/{artifact-id}")
    public ResponseEntity requestToBorrowArtifact(@PathVariable(name = "researcher-id") Integer researcherId,@PathVariable(name = "artifact-id") Integer artifactId,@RequestBody @Valid RequestIDTO requestIDTO){
        researcherService.requestToBorrowArtifact(researcherId,artifactId,requestIDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Artifact requested successfully"));
    }

    @PostMapping("/give-feedback-on-artifact-owner/{researcher-id}/{contributor-id}")
    public ResponseEntity giveFeedbackOnArtifactOwner(@PathVariable(name = "researcher-id") Integer researcherId,@PathVariable(name="contributor-id") Integer contributorId,@RequestBody @Valid FeedbackDTO feedbackDTO){
        researcherService.giveFeedbackOnArtifactOwner(researcherId,contributorId,feedbackDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Feedback sent successfully"));
    }

    @GetMapping("/get-feedbacks/{researcher-id}")
    public ResponseEntity getFeedbacks(@PathVariable(name = "researcher-id") Integer researcherId){
        return ResponseEntity.status(200).body(researcherService.getFeedbacks(researcherId));
    }

    @GetMapping("/getRecommendation/{researcher_id}")
    public ResponseEntity getRecommendation (@PathVariable Integer researcher_id){
        return ResponseEntity.status(200).body(researcherService.getRecommendation(researcher_id));
    }
}
