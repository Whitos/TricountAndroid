package com.example.tricount;

import java.util.List;

public class Tricount {
    private String titre;
    private String devise;
    private List<Participant> participants;

    public Tricount(String titre) {
        this.titre = titre;
        this.devise = "EUR";
    }

    public String getTitre() {
        return titre;
    }

    public String getDevise() {
        return devise;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

////////////////////////////////////////a verifier lajout de 2 participants 
    public void ajouterParticipant(Participant participant) {
        if (!this.participants.contains(participant)) {
            this.participants.add(participant);
            participant.addTricount(this);
        }
    }
}
