package com.sda.hangman.application;

import com.sda.hangman.domain.model.Game;

import java.util.Scanner;

public class ConsoleViews {
    private Scanner scanner;

    public ConsoleViews(Scanner scanner){
        this.scanner = scanner;
    }

    public Integer mainMenu(){
        System.out.println("1. Start");
        System.out.println("2. Wyniki");
        System.out.println("0. Koniec");
        return getIntValue();
    }

    private Integer getIntValue() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public char displayGame(Game game){
        char[] phraseStatus = game.getPhraseStatus();
        int leftAttemps = game.getLeftAttemps();
        String phraseStatusAsString = new String(phraseStatus);
        System.out.println(phraseStatusAsString + " (" + leftAttemps + ") ");
        return scanner.next().charAt(0);
    }

    public void displayWrongLetterAdded() {
        System.out.println("Podano niepoprawną literę");
    }

    public void displayGameWon() {
        System.out.println("Wygrałeś/aś !");
        waitForAction();
    }

    private void waitForAction() {
        System.out.println("Wciśnij dowolny klawisz żeby kontynuować");
        scanner.nextLine();
    }

    public void displayGameLose() {
        System.out.println("Przegrałeś/aś !");
        waitForAction();
    }
}
