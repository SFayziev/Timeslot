package com.sh.timeslot.model.response;

import com.sh.timeslot.db.entity.Contact;
import lombok.Data;

@Data
public class BranchResponse {
    private Long id ;
    private String name ;
    private Contact contact;

}
