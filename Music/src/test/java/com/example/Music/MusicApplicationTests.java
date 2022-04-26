package com.example.Music;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Music.model.Music;
import com.example.Music.repository.MusicRepository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MusicApplicationTests {

	@Autowired
	MusicRepository musicRepo;
	
	//CREATE
	@Test
	public void a_testCreate() {
		Music track = new Music();
		track.setId(1L);
		track.setName("One Beer");
		track.setArtist("MF Doom");
		track.setGenre("Hip-Hop");
		track.setDurationInSeconds(270);
		musicRepo.save(track);
		assertNotNull(musicRepo.findById(1L).get());
	}
	
	//READ ALL
	@Test
	public void b_testReadAll() {
		List<Music> playlist = musicRepo.findAll();
		assertTrue(playlist.size() > 0);
	}
	
	//READ
	@Test
	public void c_testReadTrack() {
		Music track = musicRepo.findById(1L).get();
		assertEquals("Hip-Hop", track.getGenre());
	}
	
	//UPDATE
	@Test
	public void d_testUpdate() {
		Music track = musicRepo.findById(1L).get();
		track.setGenre("Rap");
		musicRepo.save(track);
		assertNotEquals("Hip-Hop", track.getGenre());
	}
	
	//DELETE
	@Test
	public void e_testDelete() {
		musicRepo.deleteById(1L);
		assertFalse(musicRepo.existsById(1L));
	}
	
}
