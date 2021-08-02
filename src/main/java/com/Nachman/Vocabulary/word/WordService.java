package com.Nachman.Vocabulary.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getWords() {
        return wordRepository.findAll();
    }

    public void addNewWord(@RequestBody Word word) {
        Optional<Word> optionalWord = wordRepository.findWordByEnglish(word.getEnglish());
        if (optionalWord.isPresent())
            throw new IllegalStateException("This word already exist.");
        wordRepository.save(word);

    }

    public void deleteWord(Long wordId) {
        boolean exists = wordRepository.existsById(wordId);
        if (!exists) throw new IllegalStateException("This word doesnt exists");
        wordRepository.deleteById(wordId);
    }

    @Transactional
    public void updateWord(Long wordId, String english, String hebrew) {
        Word word = wordRepository.findById(wordId).orElseThrow(() ->
                new IllegalStateException("this word doesn't exists"));
        if (english != null && english.length() > 0)
            word.setEnglish(english);
        if (hebrew != null && hebrew.length() > 0)
            word.setHebrew(hebrew);
    }
}
