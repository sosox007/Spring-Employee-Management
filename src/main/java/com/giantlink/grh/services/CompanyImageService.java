package com.giantlink.grh.services;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.giantlink.grh.entities.CompanyImage;
import com.giantlink.grh.models.responses.CompanyImageResponse;

public interface CompanyImageService {

    CompanyImageResponse saveDb(MultipartFile image, Integer id) throws IOException;

    CompanyImageResponse saveLocal(MultipartFile image, Integer id) throws IOException;

    CompanyImage getImage(String imageId);

    void initPath();

    public Path getUploadPath();
}
