package com.example.capstone3.Repository;

import com.example.capstone3.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Mshari
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Image findImageById(Integer id);

}
