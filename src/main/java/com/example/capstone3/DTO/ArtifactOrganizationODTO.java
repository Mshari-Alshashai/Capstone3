package com.example.capstone3.DTO;

import com.example.capstone3.Model.Category;
import com.example.capstone3.Model.Certificate;
import com.example.capstone3.Model.Image;
import com.example.capstone3.Model.Tag;

import java.util.Set;

public class ArtifactOrganizationODTO {

    private String name;

    private String type;

    private String origin;

    private String era;

    private String location;

    private String condition;

    private Boolean availability;

    private Set<Image> images;

    private Set<Tag> tags;

    private Category category;

    private Set<Certificate> certificates;

    private String contributorName;
}
