package com.ko.playground.basic.core.parent.application.input.command;

import com.ko.playground.basic.core.parent.domain.Parent;
import lombok.Getter;

@Getter
public record RegisterParentCommand(String email, String password) {
    public Parent of(String encodedPassword) {
        return Parent.create(email, encodedPassword);
    }
}
