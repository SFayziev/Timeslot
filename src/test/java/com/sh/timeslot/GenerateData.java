package com.sh.timeslot;


import com.github.javafaker.Faker;
import com.sh.timeslot.common.enums.BaseStatus;
import com.sh.timeslot.db.entity.Address;
import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.db.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {


    protected Faker faker = new Faker();

    List<Company> genarateCompanys(int count) {
        List<Company> companyList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            companyList.add(generateCompany());
        }
        return companyList;
    }

    Company generateCompany() {
        com.github.javafaker.Company comp = faker.company();
        return Company.builder()
                .status(BaseStatus.ACTIVE)
                .name(comp.name())
                .address(generateAddress())
                .build();
    }


    Address generateAddress(){
        com.github.javafaker.Address faddress=  faker.address();
        return Address.builder().addressTwo(faddress.streetName()  )
                .addressOne( faddress.fullAddress() )
                .city(faddress.city())
                .state(faddress.state())
                .zipCode(faddress.zipCode())
                .build();
    }

    Contact generateContact(){
       return Contact.builder()
               .email(faker.internet().emailAddress())
               .phone(faker.phoneNumber().phoneNumber())
               .address(generateAddress()).build();

    }


}
