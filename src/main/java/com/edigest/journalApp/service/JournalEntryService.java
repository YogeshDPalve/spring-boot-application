package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
     private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String username){
        journalEntry.setDate(LocalDateTime.now()); // set date
        JournalEntry saved = journalEntryRepository.save(journalEntry); // saving updated journal entry (date updated)

        User user = userService.findByUserName(username); // find user by username
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);

    }
    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findOne(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id, String username){
        User user = userService.findByUserName(username);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);






    }

}
