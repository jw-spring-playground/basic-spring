package com.ko.playground.basic.core.santa.application.input.command;

import com.ko.playground.basic.core.santa.domain.Santa;

public record RegisterSantaCommand(String email, String password) {
    public Santa of(String encodedPassword) {
        return new Santa(email, encodedPassword);
    }
}
