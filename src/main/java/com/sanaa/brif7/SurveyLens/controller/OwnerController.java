package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.service.impl.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerResponseDTO> createOwner(@Valid @RequestBody OwnerCreateDTO createOwnerDTO) {
        OwnerResponseDTO owner = ownerService.create(createOwnerDTO);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> getOwnerById(@Exists(entity = Owner.class , message = "owner not found.") @PathVariable("id") Long id) {
        OwnerResponseDTO owner = ownerService.findById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OwnerResponseDTO>> getAllOwners(){
        List<OwnerResponseDTO> owners = ownerService.findAll();
        return ResponseEntity.ok(owners);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@Exists(entity = Owner.class , message = "owner not found.") @PathVariable("id") Long id) {
        ownerService.delete(id);
        return new ResponseEntity<>("Owner is deleted", HttpStatus.OK);
    }




    @PutMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> updateOwner(
            @Exists(entity = Owner.class, message = "Owner not found") @PathVariable("id") Long id,
            @Valid @RequestBody OwnerUpdateDTO updateOwnerDTO
    )

    {
        OwnerResponseDTO updatedOwner = ownerService.update(id, updateOwnerDTO);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    }
