package com.sda.hangman.domain;

import com.sda.hangman.domain.model.Game;
import com.sda.hangman.domain.model.GameStatus;
import com.sda.hangman.domain.port.PhraseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GameFactoryTest {

    @Test
    public void shouldCreateGameInstanceWithRandomPhrase() {
        //given
        PhraseRepository phraseRepository = Mockito.mock(PhraseRepository.class);
        Mockito.when(phraseRepository.getRandomPhrase()).thenReturn("test frazy");

        GameFactory gameFactory = new GameFactory(phraseRepository);

        //when
        Game game = gameFactory.createGame();

        //then
        Assert.assertEquals("test frazy", game.getPhrase());
        Assert.assertArrayEquals(new char[]{'_', '_', '_', '_', ' ', '_', '_', '_', '_', '_'},
                game.getPhraseStatus());
        Assert.assertEquals(GameStatus.NEW, game.getStatus());

    }

}
