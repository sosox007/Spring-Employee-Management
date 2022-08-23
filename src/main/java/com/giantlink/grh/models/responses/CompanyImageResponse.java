package com.giantlink.grh.models.responses;

import com.giantlink.grh.entities.Company;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyImageResponse {
    private String id;
    private String imageName;
    private String imageLink;
    private String imageType;
    private Company company;
}
