package com.example.Music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Music.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
