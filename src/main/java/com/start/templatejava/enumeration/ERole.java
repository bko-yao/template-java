package com.start.templatejava.enumeration;

public enum ERole {
    ADMIN("admin"),
    EMPLOYEE("employee"),
    CLIENT("client");

    private final String designation;

    ERole(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
