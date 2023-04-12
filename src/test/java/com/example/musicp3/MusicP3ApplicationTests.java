package com.example.musicp3;

import com.example.musicp3.controller.MusicController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MusicP3ApplicationTests {
    @Autowired
    MusicController controller;
    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
