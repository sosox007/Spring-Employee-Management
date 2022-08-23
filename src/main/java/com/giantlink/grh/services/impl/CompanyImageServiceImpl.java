package com.giantlink.grh.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.entities.CompanyImage;
import com.giantlink.grh.models.responses.CompanyImageResponse;
import com.giantlink.grh.repositories.CompanyImageRepository;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyImageService;

import org.springframework.util.StringUtils;

@Service
public class CompanyImageServiceImpl implements CompanyImageService {

    private final Path uploadPath = Paths.get("uploads");
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyImageRepository companyImageRepository;

    @Override
    public CompanyImageResponse saveDb(MultipartFile image, Integer id) throws IOException {
        Optional<Company> findById = companyRepository.findById(id);
        if (findById.isPresent()) {
            CompanyImage build = CompanyImage.builder().company(findById.get()).imageType(image.getContentType()).imageName(image.getOriginalFilename())
                    .imageType(image.getContentType()).imageFile(image.getBytes()).build();
            companyImageRepository.save(build);
            return CompanyImageResponse.builder().id(build.getId()).company(build.getCompany())
                    .imageName(build.getImageName()).imageType(build.getImageType()).build();

        }
        return null;
    }

    @Override
    public CompanyImage getImage(String imageId) {
        // TODO Auto-generated method stub
        Optional<CompanyImage> findById = companyImageRepository.findById(imageId);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public void initPath() {
        boolean exists = Files.exists(uploadPath);
        if (!exists) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CompanyImageResponse saveLocal(MultipartFile image, Integer id) throws IOException {
        Optional<Company> findById = companyRepository.findById(id);
        if (findById.isPresent()) {
            String imageName = StringUtils.cleanPath(image.getOriginalFilename());
            Files.copy(image.getInputStream(), uploadPath.resolve(imageName));
            CompanyImage build = CompanyImage.builder().company(findById.get()).imageName(imageName)
                    .imageType(image.getContentType()).build();
            companyImageRepository.save(build);
            return CompanyImageResponse.builder().id(build.getId()).company(build.getCompany())
                    .imageName(build.getImageName()).imageType(build.getImageType()).build();
        }
        return null;
    }

    @Override
    public Path getUploadPath() {
        return this.uploadPath;
    }

}
