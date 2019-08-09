package com.sh.timeslot.model.response;

import com.sh.timeslot.common.enums.BaseStatus;
import lombok.Data;

@Data
public class CompanyResponse  {
    private Long id ;
    private String name ;
    private AddressResponse address;
    private String phone ;
    private String email ;
    private BaseStatus status;

}
