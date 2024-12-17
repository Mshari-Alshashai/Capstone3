package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "(type='exhibit' or type='research') and (decision='pending' or decision='accepted' or decision='rejected')")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "please enter a type")
    @Pattern(regexp = "^(?i)(exhibit|research)$")
    @Column(columnDefinition = "varchar(8) not null")
    private String type;

    @NotNull(message = "Please enter a start date")
    @Column(columnDefinition = "timestamp not null")
    private LocalDateTime startDate;

    @NotNull(message = "Please enter an end date")
    @Column(columnDefinition = "timestamp not null")
    private LocalDateTime endDate;


    @Pattern(regexp = "^(?i)(pending|accepted|rejected)$")
    @Column(columnDefinition = "varchar(8) not null")
    private String decision="pending";

    @ManyToOne
    @JsonIgnore
    private Contributor contributor;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp not null")
    private LocalDateTime createdAt;
}