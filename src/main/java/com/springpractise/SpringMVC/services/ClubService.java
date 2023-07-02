package com.springpractise.SpringMVC.services;

import com.springpractise.SpringMVC.dto.ClubDto;
import com.springpractise.SpringMVC.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto club);


    ClubDto findClubById(int clubId);

    void updateClub(ClubDto clubDto);

    void delete(int clubId);

    List<ClubDto> searchClubs(String query);
}
