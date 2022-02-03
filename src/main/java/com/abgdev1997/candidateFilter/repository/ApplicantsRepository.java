package com.abgdev1997.candidateFilter.repository;

import com.abgdev1997.candidateFilter.models.Applicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ApplicantsRepository extends JpaRepository<Applicants, Long> {
}
