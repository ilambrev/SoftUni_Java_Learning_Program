package com.likebookapp.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private Long id;

    private String username;

    private boolean isLogged;

    public CurrentUser() {

    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void logout() {
        this.id = null;
        this.username = null;
        this.isLogged = false;
    }

}