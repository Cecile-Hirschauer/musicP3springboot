package com.example.musicp3.controller;

import com.example.musicp3.entity.Music;
import com.example.musicp3.form.CreateMusicForm;
import com.example.musicp3.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class MusicController {
    @Autowired
    private MusicRepository musicRepository;
    @RequestMapping("/")
    public String displayHome(){
        return "index";
    }

    @RequestMapping("/list")
    public @ModelAttribute("musics") List<Music> displaylist() {
        List<Music> musics = musicRepository.list();
        return musics;
    }

    @GetMapping("/view-music/"+"{id}")
    public  String displayVue(@PathVariable("id") long number, Model model, RedirectAttributes redirectAttributes) {
        Music music = musicRepository.getId(number);
        model.addAttribute("music", music);
        return "view-music";
    }

    @GetMapping("/create-music")
    public String displayAdd(@ModelAttribute CreateMusicForm createMusicForm) {
        return "create-music";
    }

    @PostMapping("/createMusic")
    public String createMusic(@ModelAttribute CreateMusicForm createMusicForm) {
        System.out.println("je suis dans le postMapping");
        Music music = new Music();
        music.setTitle(createMusicForm.getTitle());
        music.setDescription(createMusicForm.getDescription());
        musicRepository.add(music);
        return "successForm";

    }

    @GetMapping("/edit-music/{id}")
    public String displayUpdateMusicForm(@PathVariable("id") long number, Model model) {

        Music music = musicRepository.getId(number);
        System.out.println("music object: " + music);
        CreateMusicForm createMusicForm = new CreateMusicForm(); // initialiser l'objet CreateMusicForm

        createMusicForm.setTitle(music.getTitle());
        createMusicForm.setDescription(music.getDescription());
        model.addAttribute("createMusicForm", music);
        return "edit-music";
    }


    @PostMapping("/updateMusic/{id}")
    public String updateMusic(@PathVariable("id") long number, @ModelAttribute CreateMusicForm createMusicForm) {

        Music music = musicRepository.getId(number);

        music.setTitle(createMusicForm.getTitle());
        music.setDescription(createMusicForm.getDescription());
        musicRepository.update(music);
        return "successFormEdit";
    }
    @PostMapping("/deleteMusic/{id}")
    public String deleteMusic(@PathVariable Long id) {
        musicRepository.deleteById(id);
        return "successDeleteForm";
    }





}
