package com.example.Music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Music.model.Music;
import com.example.Music.repository.MusicRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

        @Autowired
        MusicRepository musicRepository; 
        
        //CREATE 
        public Music createTrack(Music track) {
            return musicRepository.save(track);
        }

        // READ
        public List<Music> getTracks() {
            return musicRepository.findAll();
        }

        //READ BY ID
        public Optional<Music> getTrack(Long id) {
        	return musicRepository.findById(id);
        }
        
        // DELETE
        public void deleteTrack(Long id) {
            musicRepository.deleteById(id);
        }
        
        //UPDATE
        public Music updateTrack(Long id, Music trackDetails) {
                Music track = musicRepository.findById(id).get();
                track.setName(trackDetails.getName());
                track.setGenre(trackDetails.getGenre());
                track.setArtist(trackDetails.getArtist());
                
                return musicRepository.save(track);                                
        }
        
        //PATCH
        public Music patchTrack(Long id, String name) {
        	Music track = musicRepository.findById(id).get();
            track.setName(name);
            
            return musicRepository.save(track);
        }
}
