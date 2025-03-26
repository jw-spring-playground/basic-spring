package com.ko.playground.basic.core.children.application;

import com.ko.playground.basic.core.children.application.input.RegisterChildren;
import com.ko.playground.basic.core.children.application.input.command.RegisterChildrenCommand;
import com.ko.playground.basic.core.children.application.output.ChildrenRepository;
import com.ko.playground.basic.core.children.domain.Children;
import org.springframework.stereotype.Service;

@Service
public class ChildrenService implements RegisterChildren {
    private final ChildrenRepository childrenRepository;

    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public void register(RegisterChildrenCommand command) {
        Children children = Children.create(
            command.getName(),
            command.getSex(),
            command.getYearOfBirth(),
            null,
            command.getParentId()
        );
        childrenRepository.save(children);
    }

}
