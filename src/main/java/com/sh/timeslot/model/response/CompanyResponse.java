package com.sh.timeslot.model.response;

import com.sh.timeslot.db.entity.Address;
import com.sh.timeslot.db.entity.Company;
import lombok.Data;

@Data
public class CompanyResponse  {

    private String name ;
    private Address address;

    private String phone ;
    private String email ;

}
