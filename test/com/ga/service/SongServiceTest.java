package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.SongDao;
import com.ga.dao.UserDao;
import com.ga.entity.Song;
import com.ga.entity.User;
import com.ga.entity.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class SongServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private SongDao songDao;

    @InjectMocks
    private  SongServiceImpl songService;

    @InjectMocks
    private Song song;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeDummySong() {
        song.setSongId(1);
        song.setName("xyz");
        song.setLength(1);
    }

    @Test
    public void createSong() {
        when(songDao.createSong(any())).thenReturn(song);

        assertEquals(song.getName(), songService.createSong(song).getName());
    }

    @Test
    public void updateSong() {
        when(songDao.updateSong(any(), anyLong())).thenReturn(song);

        assertEquals(song, songService.updateSong(song, song.getSongId()));
    }

    @Test
    public void deleteSong() {
        when(songDao.deleteSong(anyLong())).thenReturn(1L);

        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(songService.deleteSong(1L)));
    }
}
