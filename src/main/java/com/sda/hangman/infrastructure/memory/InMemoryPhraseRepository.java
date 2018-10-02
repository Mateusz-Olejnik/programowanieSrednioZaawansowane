package com.sda.hangman.infrastructure.memory;

import com.sda.hangman.domain.port.PhraseRepository;

import java.util.List;
import java.util.Random;

public class InMemoryPhraseRepository implements PhraseRepository {

    private List<String> phrases;
    private Random random;

    public InMemoryPhraseRepository(List<String> phrases) {
        this.phrases = phrases;
        this.random = new Random();
    }

    @Override
    public String getRandomPhrase() {
        int randomIndex = random.nextInt(phrases.size());
        return phrases.get(randomIndex);
    }
}
