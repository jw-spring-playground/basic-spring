package com.ko.playground.basic.core.parent.application.output;

import com.ko.playground.basic.core.parent.domain.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ParentRepository extends Repository<Parent, Long> {
    void save(Parent parent);

    @Query("SELECT p FROM Parent p WHERE p.email = :email")
    Optional<Parent> findByEmail(String email);
}
