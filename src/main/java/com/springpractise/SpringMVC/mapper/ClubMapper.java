package com.springpractise.SpringMVC.mapper;

import com.springpractise.SpringMVC.dto.ClubDto;
import com.springpractise.SpringMVC.models.Club;

import java.util.stream.Collectors;

import static com.springpractise.SpringMVC.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDto club) {
        Club clubDto=Club.builder().id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn()).build();
        return clubDto;
    }

    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto= ClubDto.builder().id(club.getId()).title(club.getTitle()).photoUrl(club.getPhotoUrl())
                .content(club.getContent()).createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event)->mapToEventDto(event)).collect(Collectors.toList())).build();
        return clubDto;
    }
}
