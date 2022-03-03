package com.company.Services;

public interface User {
    String getUsername();

    void changeUsername(String username);

    String getPassword();

    void changePassword(String password);

    int getID();
}
