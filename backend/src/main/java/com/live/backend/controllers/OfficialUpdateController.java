package com.live.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.live.backend.models.OfficialUpdate;
import com.live.backend.services.OfficialUpdateService;

@RestController
@RequestMapping("/api/official-updates")
public class OfficialUpdateController {

    @Autowired
    private OfficialUpdateService officialUpdateService;

    @GetMapping
    public ResponseEntity<List<OfficialUpdate>> getAllOfficialUpdates() {
        List<OfficialUpdate> updates = officialUpdateService.findAll();
        return new ResponseEntity<>(updates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficialUpdate> getOfficialUpdateById(@PathVariable Long id) {
        Optional<OfficialUpdate> update = officialUpdateService.findById(id);
        return update.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OfficialUpdate> createOfficialUpdate(@RequestBody OfficialUpdate officialUpdate) {
        OfficialUpdate savedUpdate = officialUpdateService.save(officialUpdate);
        return new ResponseEntity<>(savedUpdate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfficialUpdate> updateOfficialUpdate(@PathVariable Long id, @RequestBody OfficialUpdate officialUpdate) {
        Optional<OfficialUpdate> existingUpdate = officialUpdateService.findById(id);
        if (existingUpdate.isPresent()) {
            OfficialUpdate updatedUpdate = officialUpdateService.save(officialUpdate);
            return new ResponseEntity<>(updatedUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOfficialUpdate(@PathVariable Long id) {
        officialUpdateService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}