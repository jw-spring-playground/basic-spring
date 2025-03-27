package com.ko.playground.basic.core.parent.application.output;

import com.ko.playground.basic.core.parent.domain.Parent;
import org.springframework.data.repository.Repository;

public interface ParentRepository extends Repository<Parent, Long> {
    void save(Parent parent);
}
