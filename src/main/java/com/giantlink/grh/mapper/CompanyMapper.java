package com.giantlink.grh.mapper;


import com.giantlink.grh.entities.Company;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;



@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyMapper {

	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	Company CompanyRequestToCompany(CompanyRequest companyRequest);
	CompanyResponse CompanyToCompanyResponse(Company Company);
	List<CompanyResponse> mapReponse(List<Company> companies);
	//Page<Company> entityToPage(Page<Company> page);
	
	default List<CompanyResponse> entityToPage(Page<Company> page) {
        List<CompanyResponse> companytoList = mapReponse(page.getContent());
        return companytoList;
    }
	
}

