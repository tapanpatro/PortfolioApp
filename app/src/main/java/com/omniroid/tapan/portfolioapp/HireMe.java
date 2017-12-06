package com.omniroid.tapan.portfolioapp;

/**
 * Created by hp on 10/17/2017.
 */

public class HireMe {


    String name,email,query;

    public HireMe(String name, String email, String query) {
        this.name = name;
        this.email = email;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
