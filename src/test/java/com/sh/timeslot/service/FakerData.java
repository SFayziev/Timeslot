package com.sh.timeslot.service;

import com.github.javafaker.Address;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.sh.timeslot.model.request.CompanyRequest;

public class FakerData {
    private  static Faker faker = new Faker();


    public   static CompanyRequest generateCompanyRequest(){

        Company comp =  faker.company();
        Address addr = faker.address();
        com.sh.timeslot.db.entity.Address address = com.sh.timeslot.db.entity.Address.builder().zipcode(addr.zipCode())
                .state(addr.state())
                .addressOne(addr.streetAddress())
                .city(addr.cityName())
                .addressTwo(addr.secondaryAddress())
                .build();

        return  CompanyRequest.builder()
                .email("test@gmail.com.test" )
                .name(comp.name() )
                .address(address)
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }


}
