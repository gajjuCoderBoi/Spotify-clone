package com.ga.controller;

import com.ga.entity.Song;
import com.ga.entity.User;
import com.ga.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/list")
    public List<Song> songList() {
        return songService.songList();
    }

    @PostMapping("/create")
    public Song create(@RequestBody Song song){
        return songService.createSong(song);
    }

    @PutMapping("/{songId}")
    public Song update(@RequestBody Song song, @PathVariable(value = "songId") Long songId){
        return songService.updateSong(song, songId);
    }

    @DeleteMapping("/{songId}")
    public long delete(@PathVariable(value = "songId") Long songId){
        return songService.deleteSong(songId).getSongId();
    }

    @GetMapping("/{songId}/listeners")
    public List<User> listeners(@PathVariable(value = "songId") Long songId){
        return songService.listeners(songId);
    }

}
