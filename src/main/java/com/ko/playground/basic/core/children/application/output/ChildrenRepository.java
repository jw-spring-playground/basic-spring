package com.ko.playground.basic.core.children.application.output;

import com.ko.playground.basic.core.children.domain.Children;
import org.springframework.data.repository.Repository;

public interface ChildrenRepository extends Repository<Children, Long> {
    void save(Children children);
    Children findById(Long id);
}
