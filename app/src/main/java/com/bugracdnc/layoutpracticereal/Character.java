package com.bugracdnc.layoutpracticereal;

public class Character {
    String  name,
            surname,
            nickname,
            firstAppearance,
            createdBy,
            voicedBy;

    public Character(String name, String surname, String nickname, String firstAppearance, String createdBy, String voicedBy) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.voicedBy = voicedBy;
    }
}
