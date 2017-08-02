package com.task2.student2.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);


}
