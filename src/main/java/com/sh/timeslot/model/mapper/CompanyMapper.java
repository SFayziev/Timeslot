package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper extends BaseMapper<Company, CompanyRequest, CompanyResponse> {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    Company fromRequestToEntity(CompanyRequest request);

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    @Mapping(source = "identifier", target = "id")
    CompanyResponse fromEntityToResponse(Company entity);
}
