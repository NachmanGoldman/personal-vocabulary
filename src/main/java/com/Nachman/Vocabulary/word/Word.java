package com.Nachman.Vocabulary.word;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Word {
    @Id
    @SequenceGenerator(
            name = "word_sequence",
            sequenceName = "word_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "word_sequence"
    )
    private Long id;
    private String hebrew;
    private String english;
    private Integer garde;
    private LocalDate dateCreated;

    public Word() {
        this.garde = 0;
        this.dateCreated = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getHebrew() {
        return hebrew;
    }

    public String getEnglish() {
        return english;
    }

    public Integer getGarde() {
        return garde;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

//  //  public void setId(Long id) {
//        this.id = id;
//    }

    public void setHebrew(String hebrew) {
        this.hebrew = hebrew;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}

