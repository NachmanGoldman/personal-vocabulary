package com.example.Dictionary.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository
        extends JpaRepository<Word,Long> {

    //Optional<Word> findWordByHebrew (String hebrew);
    Optional<Word> findWordByEnglish (String english);
}
