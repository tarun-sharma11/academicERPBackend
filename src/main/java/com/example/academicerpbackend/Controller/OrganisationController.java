package com.example.academicerpbackend.Controller;


import com.example.academicerpbackend.Exception.ResourceNotFound;
import com.example.academicerpbackend.Model.Organisation;
import com.example.academicerpbackend.Repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class OrganisationController {



    @Autowired
    private OrganisationRepository organisationRepository;

    @GetMapping("/organisations")
    public List<Organisation> getAllOrganisation(){
        return organisationRepository.findAll();
    }

    @PostMapping("/organisations")
    public Organisation createOrganisation(@RequestBody Organisation organisation){
        return organisationRepository.save(organisation);
    }

    @GetMapping("/organisation/{id}")
    public ResponseEntity<Organisation> getOrganisationById(@PathVariable Long id){
        Organisation organisation = organisationRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));
        return ResponseEntity.ok(organisation);
    }

    @PutMapping("/organisation/{id}")
    public ResponseEntity<Organisation> updateOrganisationById(@PathVariable Long id, @RequestBody Organisation organisationDetails){
        Organisation organisation = organisationRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));

        organisation.setName(organisationDetails.getName());
        organisation.setAddress(organisationDetails.getAddress());

        Organisation updatedorganisation = organisationRepository.save(organisation);
        return ResponseEntity.ok(updatedorganisation);
    }

    @DeleteMapping("/organisation/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteOrganisation(@PathVariable Long id){
        Organisation organisation = organisationRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));
        organisationRepository.delete(organisation);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
