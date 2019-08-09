package com.sh.timeslot.model.request;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressRequest {

    private String addressOne;


    private String addressTwo;


    private String city;


    private String state;


    private String zipCode;
}
