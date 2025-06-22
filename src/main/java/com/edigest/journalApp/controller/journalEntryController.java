package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    // POST /journal
    @PostMapping()
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry ){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("{id}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId id){
        return journalEntryService.findOne(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable ObjectId id){
        journalEntryService.deleteById(id);
        return true;
    }

    @PutMapping("{id}")
    public JournalEntry updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findOne(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
    journalEntryService.saveEntry(old);
        return old;
    }


}
