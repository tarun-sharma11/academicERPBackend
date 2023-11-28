package com.example.academicerpbackend.Repository;

import com.example.academicerpbackend.Model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
}
