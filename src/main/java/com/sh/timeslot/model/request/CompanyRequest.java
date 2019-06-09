package com.sh.timeslot.model.request;


import com.sh.timeslot.db.entity.Address;
import com.sh.timeslot.model.MongoQueryField;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyRequest  {

    @Getter(onMethod_ = { @MongoQueryField})
    private String name ;

    private Address address;

    //@Getter(onMethod_={ @MongoQueryField})
    private String phone ;

    @Getter(onMethod_={ @MongoQueryField})
    private String email ;


}
