package com.sh.timeslot.service;

import com.github.javafaker.Address;
import com.sh.timeslot.db.entity.Company;
import com.github.javafaker.Faker;
import com.sh.timeslot.model.request.AddressRequest;
import com.sh.timeslot.model.request.CompanyRequest;

public class FakerData {
    private  static Faker faker = new Faker();


    public   static CompanyRequest generateCompanyRequest(){

        com.github.javafaker.Company comp =  faker.company();
        Address addr = faker.address();
        AddressRequest address = AddressRequest.builder().zipCode(addr.zipCode())
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

    public   static  com.sh.timeslot.db.entity.Company generateCompany(){

        com.github.javafaker.Company comp =  faker.company();
        Address addr = faker.address();
        com.sh.timeslot.db.entity.Address address = com.sh.timeslot.db.entity.Address.builder().zipCode(addr.zipCode())
                .state(addr.state())
                .addressOne(addr.streetAddress())
                .city(addr.cityName())
                .addressTwo(addr.secondaryAddress())
                .build();

        Company company = new Company();

        company.setEmail("test@gmail.com.test" );
        company.setName(comp.name());
        company.setAddress(address);
        return company;

    }

}
