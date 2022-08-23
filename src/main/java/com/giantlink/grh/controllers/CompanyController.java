package com.giantlink.grh.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.entities.CompanyImage;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyImageResponse;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.services.CompanyImageService;
import com.giantlink.grh.services.CompanyService;

import java.nio.file.Path;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@Autowired
	CompanyImageService companyImageService;

	@GetMapping("/old")
	public ResponseEntity<List<CompanyResponse>> get() {

		return new ResponseEntity<>(companyService.get(), HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<CompanyResponse>> getCompanies(
			@RequestParam(value = "sortedBy", defaultValue = "name") String sortedBy,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "2") int size) {

		return new ResponseEntity<List<CompanyResponse>>(companyService.get(page, size, Sort.by(sortedBy)),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyResponse> add(@RequestBody @Valid CompanyRequest companyRequest)
			throws AlreadyExistsException {
		return new ResponseEntity<>(companyService.add(companyRequest), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyResponse> update(@PathVariable Integer id,
			@RequestBody @Valid CompanyRequest companyRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(companyService.update(id, companyRequest), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
		return new ResponseEntity<>(companyService.get(id), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<CompanyResponse> get(@PathVariable String name) throws ResourceNotFoundException {
		return new ResponseEntity<>(companyService.get(name), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
		companyService.delete(id);
		return new ResponseEntity<>("Company deleted", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<CompanyImageResponse> upload(@PathVariable("id") Integer companyId,
			@RequestParam("image") MultipartFile image) throws IOException {
		CompanyImageResponse save = companyImageService.saveDb(image, companyId);
		String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/company/")
				.path("/download/").path(save.getId()).toUriString();
		save.setImageLink(imageUrl);
		return new ResponseEntity<CompanyImageResponse>(save, HttpStatus.OK);
	}

	@PostMapping("/uploadFile/{id}")
	public ResponseEntity<CompanyImageResponse> uploadFile(@PathVariable("id") Integer companyId,
			@RequestParam("image") MultipartFile image) throws IOException {
		CompanyImageResponse save = companyImageService.saveLocal(image, companyId);
		String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/company/")
				.path("/downloadFile/").path(save.getId()).toUriString();
		save.setImageLink(imageUrl);
		return new ResponseEntity<CompanyImageResponse>(save, HttpStatus.OK);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id") String imageId) {
		CompanyImage image = companyImageService.getImage(imageId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + image.getImageName())
				.body(new ByteArrayResource(image.getImageFile()));
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") String imageId) throws MalformedURLException {
		CompanyImage image = companyImageService.getImage(imageId);
		Path imageFile = companyImageService.getUploadPath().resolve(image.getImageName());
		Resource resource = new UrlResource(imageFile.toUri());
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + image.getImageName())
				.body(resource);
	}

}
