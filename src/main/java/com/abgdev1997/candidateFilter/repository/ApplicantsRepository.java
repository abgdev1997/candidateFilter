package com.abgdev1997.candidateFilter.repository;

import com.abgdev1997.candidateFilter.models.Applicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantsRepository extends JpaRepository<Applicants, Long> {

}
