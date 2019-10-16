package com.ga.service;

import com.ga.entity.Song;

public interface SongService {
    public Song updateSong(Song Song, Long SongId);
    public Song deleteSong(Long SongId);
}
