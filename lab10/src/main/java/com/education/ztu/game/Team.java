package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

/**
 * Клас Team представляє команду учасників певного типу T.
 * @param <T> тип учасників, який успадковується від Participant
 */
public class Team<T extends Participant> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Назва команди */
    private String name;

    /** Список учасників команди */
    private List<T> participants = new ArrayList<>();

    /**
     * Конструктор з параметром
     * @param name назва команди
     */
    public Team(String name) {
        this.name = name;
    }

    /**
     * Додає нового учасника до команди
     * @param participant учасник, якого додаємо
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    /**
     * Симулює гру між цією командою та іншою
     * @param team інша команда
     */
    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is winner!");
    }

    public String getName() {
        return name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

    /**
     * Конструктор копіювання команди
     * @param team інша команда
     */
    public Team(Team<T> team) {
        this.name = team.name;
        this.participants = new ArrayList<>();
        for (T participant : team.participants) {
            this.participants.add((T) participant.clone());
        }
    }
}
