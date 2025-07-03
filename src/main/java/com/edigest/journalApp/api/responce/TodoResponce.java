package com.edigest.journalApp.api.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter @Setter
public class TodoResponce {
    @Getter @Setter
    public class GetTodo{

        @JsonProperty("_id")
        public String id;
        public String title;
        public String description;
        public int isread;
        public Date createdAt;
        public Date updatedAt;
    }
 }
