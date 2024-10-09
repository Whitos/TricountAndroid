package com.example.tricount;

public class Participant {
    private String name;
    private String email;

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addTricount(Tricount tricount) {
        addTricount(tricount);
    }

    public String toString() {
        return "Participant: " + name + ", " + "email: " + email;
    }
}
