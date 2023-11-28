package com.example.academicerpbackend.Repository;

import com.example.academicerpbackend.Model.Organisation_Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Organisation_HrRepository extends JpaRepository<Organisation_Hr,Long> {
}
