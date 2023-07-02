package com.springpractise.SpringMVC.repository;

import com.springpractise.SpringMVC.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club,Integer> {


    Optional<Club> findByTitle(String url);
     Optional<Club> findById(int clubId);

     @Query("SELECT c FROM Club c WHERE c.title LIKE concat('%',:query,'%') ")
    List<Club> searchClubs(String query);


}
