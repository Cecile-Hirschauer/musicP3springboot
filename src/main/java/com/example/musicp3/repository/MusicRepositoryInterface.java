package com.example.musicp3.repository;


import com.example.musicp3.entity.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepositoryInterface extends CrudRepository<Music, String> {

}