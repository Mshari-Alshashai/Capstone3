package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
//Waleed
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "contributor")
    private Set<Request> requests;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp not null")
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributor")
    private Set<Artifact> artifacts;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributor")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "contributor")
    @JsonIgnore
    private Set<Report> reports;

    @ManyToOne
    @JsonIgnore
    private BanList banList;
}
