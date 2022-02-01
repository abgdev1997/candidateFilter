package com.abgdev1997.candidateFilter.repository;

import com.abgdev1997.candidateFilter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEnterpriseEmail(String enterpriseEmail);

    Optional<User> findByEnterpriseEmail(String enterpriseEmail);
}
