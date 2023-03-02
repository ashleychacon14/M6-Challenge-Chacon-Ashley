package com.company.customerdataservice.controller;
import com.company.customerdataservice.model.Note;
import com.company.customerdataservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAlbums() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Note getAlbumById(@PathVariable int id) {

        Optional<Note> returnVal = noteRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public Note addAlbum(@RequestBody Note album) {
        return noteRepository.save(album);
    }

    @PutMapping("/notes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Note album) {
        noteRepository.save(album);
    }

    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) {
        noteRepository.deleteById(id);
    }
}

