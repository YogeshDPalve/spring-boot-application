package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.repository.JournalEntryRepository;
import com.edigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/journals")
public class journalEntryControllerV2 {


//    private  Map<Long,JournalEntry>journalEntries = new HashMap<>();
//    @GetMapping
//    public List<JournalEntry> getAll(){
//    return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public Boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//
//    }
//
//    @GetMapping("{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("{myId}")
//    public JournalEntry deleteJournalEntryById(@PathVariable long myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("{id}")
//    public JournalEntry updateJournalEntryById(@PathVariable long id,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(id, myEntry);
//    }


}
