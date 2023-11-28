package com.example.academicerpbackend.Controller;

import com.example.academicerpbackend.Exception.ResourceNotFound;
import com.example.academicerpbackend.Model.Organisation;
import com.example.academicerpbackend.Model.Organisation_Hr;
import com.example.academicerpbackend.Repository.Organisation_HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class Organisation_HrController {
    @Autowired
    private Organisation_HrRepository organisation_hrRepository;

    @GetMapping("/organisation/hrs")
    public List<Organisation_Hr> getAllOrganisationHr(){
        return organisation_hrRepository.findAll();
    }

    @PostMapping("/organisation/hrs")
    public Organisation_Hr createOrganisationHr(@RequestBody Organisation_Hr organisationHr){
        return organisation_hrRepository.save(organisationHr);
    }



    @GetMapping("/organisation/hr/{id}")
    public ResponseEntity<Organisation_Hr> getOrganisationHrById(@PathVariable Long id){
        Organisation_Hr organisation_hr = organisation_hrRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));
        return ResponseEntity.ok(organisation_hr);
    }

    @PutMapping("/organisation/hr/{id}")
    public ResponseEntity<Organisation_Hr> updateOrganisationHrById(@PathVariable Long id, @RequestBody Organisation_Hr organisation_hrDetails){
        Organisation_Hr organisation_hr = organisation_hrRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));

        organisation_hr.setFirst_name(organisation_hrDetails.getFirst_name());
        organisation_hr.setLast_name(organisation_hrDetails.getLast_name());
        organisation_hr.setEmail(organisation_hrDetails.getEmail());
        organisation_hr.setContact_number(organisation_hrDetails.getContact_number());
        organisation_hr.setOrganisation(organisation_hrDetails.getOrganisation());

        Organisation_Hr updatedOrganisationHr = organisation_hrRepository.save(organisation_hr);
        return ResponseEntity.ok(updatedOrganisationHr);
    }

    @DeleteMapping("/organisation/hr/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteOrganisation(@PathVariable Long id, @RequestBody Organisation organisation_hrDetails){
        Organisation_Hr organisation_hr = organisation_hrRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organisation not exists with id :"+id));
        organisation_hrRepository.delete(organisation_hr);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
