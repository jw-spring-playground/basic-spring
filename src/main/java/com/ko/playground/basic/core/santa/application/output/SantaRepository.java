package com.ko.playground.basic.core.santa.application.output;

import com.ko.playground.basic.core.santa.domain.Santa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SantaRepository extends Repository<Santa, Long> {
    void save(Santa santa);

    @Query("SELECT s FROM Santa s WHERE s.email = :email")
    Optional<Santa> findByEmail(String email);
}
