package com.sda.hangman.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class GameTest {

    @Test
    public void shouldReturnTrueAndAddCharacterToPhraseStatusWhenLetterCanBeAdded() {
        //given
        Game game = createSampleGame();

        //when
        boolean result = game.addNextLetter('a');

        //then
        Assert.assertTrue(result);
        Assert.assertArrayEquals(new char[]{'A', '_', 'a', ' ', '_', 'a', ' ', '_', '_', '_', 'a'}, game.getPhraseStatus());

    }


    @Test
    public void addNextLettershouldReturnFalseAndDoNotUpdatePhraseStatusAndDecrementLeftAttempsWhenLetterIsNotPresentInPhrase() {
        //given
        Game game = createSampleGame();
        Integer leftAttempts = game.getLeftAttemps();

        // when
        boolean result = game.addNextLetter('z');

        //then
        Assert.assertFalse(result);
        Assert.assertArrayEquals(new char[]{'_', '_', '_', ' ', '_', '_', ' ', '_', '_', '_', '_'}, game.getPhraseStatus());
        Assert.assertEquals((Integer) (leftAttempts - 1), game.getLeftAttemps());

    }

    @Test
    public void addNextLettershouldReturnFalseAndDoNotUpdatePhraseStatusAndDecrementLeftAttempsWhenLetterIsAddedSecondTime() {
        //given
        Game game = createSampleGame();
        Integer leftAttempts = game.getLeftAttemps();

        // when
        game.addNextLetter('a');
        boolean result = game.addNextLetter('a');

        //then
        Assert.assertFalse(result);
        Assert.assertArrayEquals(new char[]{'A', '_', 'a', ' ', '_', 'a', ' ', '_', '_', '_', 'a'}, game.getPhraseStatus());
        Assert.assertEquals((Integer) (leftAttempts - 1), game.getLeftAttemps());

    }

    @Test
    public void addNextLettershouldChangeStatusToWonWhenLastLetterIsAdded() {
        //given
        Game game = createSampleGameWithCustomPhrasesState((new char[]{'A', '_', 'a', ' ', 'm', 'a', ' ', 'k', 'o', 't', 'a'}));

        //when
        boolean result = game.addNextLetter('l');

        //then
        Assert.assertTrue(result);
        Assert.assertArrayEquals((new char[]{'A', 'l', 'a', ' ', 'm', 'a', ' ', 'k', 'o', 't', 'a'}),
                game.getPhraseStatus());
        Assert.assertEquals(GameStatus.WON, game.getStatus());


    }

    @Test
    public void addNextLettershouldChangeStatusToLoseWhenLeftAttemptsEqualsIsZero() {
        //given
        Game game = createSampleGameBuilder()
                .leftAttemps(1)
                .build();

        //when
        boolean result = game.addNextLetter('z');

        //then
        Assert.assertFalse(result);
        Assert.assertEquals((Integer) 0, game.getLeftAttemps());
        Assert.assertEquals(GameStatus.LOSE, game.getStatus());

    }

    private Game createSampleGameWithCustomPhrasesState(char[] phraseState) {
        return createSampleGameBuilder()
                .phraseStatus(phraseState)
                .build();
    }

    private Game createSampleGame() {
        return createSampleGameBuilder()
                .build();
    }

    private Game.GameBuilder createSampleGameBuilder() {
        return Game.builder()
                .phrase("Ala ma kota")
                .phraseStatus(new char[]{'_', '_', '_', ' ', '_', '_', ' ', '_', '_', '_', '_',})
                .leftAttemps(5)
                .startDate(Instant.now())
                .status(GameStatus.ACTIVE);
    }

}