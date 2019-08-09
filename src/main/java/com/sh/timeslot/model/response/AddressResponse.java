package com.sh.timeslot.model.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String zipCode;

}
