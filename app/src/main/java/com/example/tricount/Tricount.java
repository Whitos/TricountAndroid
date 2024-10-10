package com.example.tricount;

import java.util.List;

public class Tricount {
    private String title;
    private List<String> participants;

    // Constructor
    public Tricount(String title, List<String> participants) {
        this.title = title;
        this.participants = participants;
    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Setter for the title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for participants
    public List<String> getParticipants() {
        return participants;
    }

    // Setter for participants
    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    // Method to add a participant
    public void addParticipant(String participant) {
        if (participant != null && !participant.trim().isEmpty()) {
            this.participants.add(participant);
        }
    }

    // Method to remove a participant
    public void removeParticipant(String participant) {
        if (participant != null && this.participants.contains(participant)) {
            this.participants.remove(participant);
        }
    }

    @Override
    public String toString() {
        return "Tricount{" +
                "title='" + title + '\'' +
                ", participants=" + participants +
                '}';
    }
}
