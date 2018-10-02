package com.sda.hangman.domain;

import com.sda.hangman.domain.model.Game;
import com.sda.hangman.domain.model.GameStatus;
import com.sda.hangman.domain.port.PhraseRepository;

import java.time.Instant;

public class GameFactory {

    public static final int LEFT_ATTEMPS = 5;

    private PhraseRepository phraseRepository;

    public GameFactory(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public Game createGame() {
        String phrase = phraseRepository.getRandomPhrase();
        return Game.builder()
                .phrase(phrase)
                .phraseStatus(convertToStartingPhraseStatus(phrase))
                .status(GameStatus.NEW)
                .startDate(Instant.now())
                .leftAttemps(LEFT_ATTEMPS)
                .build();

    }

    private char[] convertToStartingPhraseStatus(String phrase) {
        char[] array = phrase.toCharArray();

        for (int i = 0; i <array.length ; i++) {
            if(Character.isLetter(array[i])){
                array[i] = '_';
            }
        }


        return array;
    }

}
