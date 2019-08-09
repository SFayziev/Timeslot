package com.sh.timeslot.model.request;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyRequest  {
    private Long id ;
    private String name ;
    private AddressRequest address;
    private String phone ;
    private String email ;
}
