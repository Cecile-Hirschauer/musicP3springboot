package com.example.musicp3.service;


import com.example.musicp3.entity.Music;
import com.example.musicp3.repository.MusicRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
    @Autowired
    private MusicRepositoryInterface musicRepositoryInterface;

    public Iterable<Music> getMusicList() {
        return musicRepositoryInterface.findAll();
    }
}

//add
//public Music add(Music music) {return musicRepositoryInterface.save(music);}
