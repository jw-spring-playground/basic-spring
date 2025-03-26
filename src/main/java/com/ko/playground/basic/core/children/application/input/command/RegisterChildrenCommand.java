package com.ko.playground.basic.core.children.application.input.command;

import com.ko.playground.basic.core.children.domain.Sex;
import lombok.Getter;

@Getter
public class RegisterChildrenCommand {
    private final String name;
    private final Long yearOfBirth;
    private final Sex sex;
    private final Long parentId;

    public RegisterChildrenCommand(String name, Long yearOfBirth, String sex, Long parentId) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.sex = Sex.valueOf(sex);
        this.parentId = parentId;
    }
}

