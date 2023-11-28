package com.example.academicerpbackend.Repository;

import com.example.academicerpbackend.Model.Organisation_Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Organisation_HrRepository extends JpaRepository<Organisation_Hr,Long> {
//    @Query("SELECT hr FROM Organisation_Hr hr JOIN FETCH hr.organisation")
//    List<Organisation_Hr> findAllOrganisationHrWithOrganisation();

//    @Query("SELECT NEW com.example.academicerpbackend.Model.Organisation_Hr(hr.id, hr.first_name, hr.last_name, hr.email, hr.contact_number, o) FROM Organisation_Hr hr JOIN hr.organisation o")
//    List<Organisation_Hr> findAllOrganisationHrDetails();
}
