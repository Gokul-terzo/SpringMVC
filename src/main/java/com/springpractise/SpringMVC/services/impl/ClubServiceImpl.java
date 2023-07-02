package com.springpractise.SpringMVC.services.impl;

import com.springpractise.SpringMVC.dto.ClubDto;
import com.springpractise.SpringMVC.models.Club;
import com.springpractise.SpringMVC.repository.ClubRepository;
import com.springpractise.SpringMVC.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springpractise.SpringMVC.mapper.ClubMapper.mapToClub;
import static com.springpractise.SpringMVC.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs=clubRepository.findAll();
        return clubs.stream().map((club)-> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club=mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(int clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club=mapToClub(clubDto);
        clubRepository.save(club);

    }

    @Override
    public void delete(int clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs=clubRepository.searchClubs(query);
        return clubs.stream().map(club-> mapToClubDto(club)).collect(Collectors.toList());
    }

}
