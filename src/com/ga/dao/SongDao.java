package com.ga.dao;

import com.ga.entity.Song;

public interface SongDao {
    public Song updateSong(Song Song, Long SongId);
    public Song deleteSong(Long SongId);
}
