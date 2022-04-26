package com.example.Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Music.model.Music;
import com.example.Music.service.MusicService;

@RestController
@RequestMapping(path = "/api")
public class MusicController {
        @Autowired
        MusicService musicService;

        //POST
        @PostMapping("/music")
        public Music createTrack(@RequestBody Music track) {
            return musicService.createTrack(track);
        }
        
        //GET
        @GetMapping("/music")
        public List<Music> readEmployees() {
            return musicService.getTracks();
        }
        
        //PATCH
        @PatchMapping("/music/{id}/{name}")
        public Music patchTrack(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) {
        	return musicService.patchTrack(id, name);
        }

        //PUT
        @PutMapping("/music/{id}")
        public Music updateTrack(@PathVariable(value = "id") Long id, @RequestBody Music trackDetails) {
        	return musicService.updateTrack(id, trackDetails);
        }
        
        //DELETE
        @DeleteMapping("/music/{id}")
        public void deleteTrack(@PathVariable(value = "id") Long id) {
        	musicService.deleteTrack(id);
        }

}
