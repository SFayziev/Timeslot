package com.sh.timeslot.model.request;


import com.sh.timeslot.db.entity.Address;
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
    private Address address;
    private String phone ;
    private String email ;
}
