package com.abgdev1997.candidateFilter.controller;

import com.abgdev1997.candidateFilter.dto.ApplicantDTO;
import com.abgdev1997.candidateFilter.dto.MessageDTO;
import com.abgdev1997.candidateFilter.models.Applicants;
import com.abgdev1997.candidateFilter.repository.ApplicantsRepository;
import com.abgdev1997.candidateFilter.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantsController {

    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    ApplicantsRepository applicantsRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Applicants>> list(){
        List<Applicants> list = applicantsRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageDTO> addApplicant(ApplicantDTO applicantRequest, MultipartFile image, MultipartFile pdf) throws IOException {
        ArrayList<String> imageArray = cloudinaryService.upload(image);
        ArrayList<String> pdfArray = cloudinaryService.upload(pdf);

        Applicants applicant = new Applicants(
                null,
                applicantRequest.getName(),
                applicantRequest.getCountry(),
                applicantRequest.getCity(),
                applicantRequest.getPhone(),
                applicantRequest.getEmail(),
                applicantRequest.getPresence(),
                applicantRequest.getRelocation(),
                imageArray.get(1),
                imageArray.get(0),
                pdfArray.get(1),
                pdfArray.get(0),
                applicantRequest.getTechnologies());

        applicantsRepository.save(applicant);

        return ResponseEntity.ok(new MessageDTO("Applicant save successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteApplicant(@PathVariable("id") Long id) throws IOException {
        Optional<Applicants> applicant = applicantsRepository.findById(id);
        if(applicant.isPresent()) {
            String imageId = applicant.get().getImageId();
            String pdfId = applicant.get().getPdfId();
            cloudinaryService.delete(imageId);
            cloudinaryService.delete(pdfId);
            return ResponseEntity.ok().body(new MessageDTO("Delete applicant!"));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/modify")
    public ResponseEntity<MessageDTO> modifyApplicant(ApplicantDTO applicantRequest){
        Optional<Applicants> applicant = applicantsRepository.findById(applicantRequest.getId());
        if(applicant.isPresent()){
            Applicants applicantModified = new Applicants(
                    applicantRequest.getId(),
                    applicantRequest.getName(),
                    applicantRequest.getCountry(),
                    applicantRequest.getCity(),
                    applicantRequest.getPhone(),
                    applicantRequest.getEmail(),
                    applicantRequest.getPresence(),
                    applicantRequest.getRelocation(),
                    applicant.get().getImage(),
                    applicant.get().getImageId(),
                    applicant.get().getPdfId(),
                    applicant.get().getPdfId(),
                    applicantRequest.getTechnologies());

            applicantsRepository.save(applicantModified);
            return ResponseEntity.ok(new MessageDTO("Applicant modify successfully!"));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/modifyFile/{id}")
    public ResponseEntity<MessageDTO> modifyFile(@PathVariable("id") Long id, MultipartFile file, String modify) throws IOException {
        Optional<Applicants> applicant = applicantsRepository.findById(id);
        if(applicant.isPresent()){
            Applicants applicantModified = new Applicants(
                    id,
                    applicant.get().getName(),
                    applicant.get().getCountry(),
                    applicant.get().getCity(),
                    applicant.get().getPhone(),
                    applicant.get().getEmail(),
                    applicant.get().getPresence(),
                    applicant.get().getRelocation(),
                    applicant.get().getImage(),
                    applicant.get().getImageId(),
                    applicant.get().getPdfId(),
                    applicant.get().getPdfId(),
                    applicant.get().getTechnologies());

            if(modify.equals("image")){
                cloudinaryService.delete(applicantModified.getImageId());
                ArrayList<String> newImage = cloudinaryService.upload(file);
                applicantModified.setImage(newImage.get(1));
                applicantModified.setImageId(newImage.get(0));
                applicantsRepository.save(applicantModified);
                return ResponseEntity.ok(new MessageDTO("Image modify successfully!"));
            }

            if(modify.equals("pdf")){
                cloudinaryService.delete(applicantModified.getPdfId());
                ArrayList<String> newPdf = cloudinaryService.upload(file);
                applicantModified.setPdf(newPdf.get(1));
                applicantModified.setPdfId(newPdf.get(0));
                applicantsRepository.save(applicantModified);
                return ResponseEntity.ok(new MessageDTO("Pdf modify successfully!"));
            }

            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }
}
