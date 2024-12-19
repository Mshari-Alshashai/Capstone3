package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Event;
import com.example.capstone3.Service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
//Bayan

    @GetMapping("/get")
    public ResponseEntity get (){
        return ResponseEntity.status(200).body(eventService.getAll());
    }

    @PostMapping("/add/{organization_id}")
    public ResponseEntity add (@PathVariable  Integer organization_id , @RequestBody @Valid Event event){
        eventService.addEvent(organization_id,event);
        return ResponseEntity.status(200).body(new ApiResponse("Event added successfully"));
    }


    @PutMapping("/update/{id}/{organization_id}")
    public ResponseEntity update (@PathVariable Integer id ,@PathVariable Integer organization_id, @RequestBody @Valid Event event){
        eventService.update(id,organization_id,event);
        return ResponseEntity.status(200).body(new ApiResponse("Event update successfully"));
    }

    @DeleteMapping("/delete/{id}/{organization_id}")
    public ResponseEntity delete (@PathVariable Integer id, @PathVariable Integer organization_id){
        eventService.delete(id,organization_id);
        return ResponseEntity.status(200).body(new ApiResponse("Event deleted successfully"));
    }

    @PutMapping("add-artifact-to-event/{organization_id}/{event_id}/{artifact_id}")
    public ResponseEntity addArtifactToEvent (@PathVariable Integer organization_id, @PathVariable Integer event_id, @PathVariable Integer artifact_id){
        eventService.addArtifactToEvent(organization_id,event_id,artifact_id);
        return ResponseEntity.status(200).body(new ApiResponse("Artifact added successfully to event"));
    }
}
