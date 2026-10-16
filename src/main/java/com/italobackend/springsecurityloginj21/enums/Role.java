package com.italobackend.springsecurityloginj21.enums;

public enum Role {

    ADMIN("Administrator"),
    USER("User");

    private String description;

    Role(String description) {
        this.description = description;
    }

    String getDescription(String description) {
        return description;
    }

}
