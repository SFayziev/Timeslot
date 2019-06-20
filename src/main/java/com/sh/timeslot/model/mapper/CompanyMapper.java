package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper extends BaseMapper<Company, CompanyRequest, CompanyResponse> {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

}
