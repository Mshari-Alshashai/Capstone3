package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contributor {//waleed
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


    @JsonIgnore
    @Column(columnDefinition = "boolean not null")
    private Boolean isBanned=false;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp not null")
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributor")
    private Set<Artifact> artifacts;

    @ManyToMany(mappedBy = "contributors")
    private Set<Notification> notifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributor")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "contributor")
    @JsonIgnore
    private Set<Report> reports;

//    @ManyToOne
//    @JsonIgnore
//    private BanList banList;
}
