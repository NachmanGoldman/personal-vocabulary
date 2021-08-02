package com.Nachman.Vocabulary.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/word")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<Word> getWords() {
        return wordService.getWords();
    }

    @PostMapping
    public void addWord(@RequestBody Word word) {
        wordService.addNewWord(word);
    }

    @DeleteMapping(path = "{wordId}")
    public void deleteWord(@PathVariable Long wordId) {
        wordService.deleteWord(wordId);
    }

    @PutMapping(path = "{wordId}")
    public void updateWord(@PathVariable Long wordId,
                           @RequestParam(required = false) String english,
                           @RequestParam(required = false) String hebrew) {
        wordService.updateWord(wordId, english, hebrew);
    }
}
