package com.sda.todo;

import com.sda.todo.model.Todo;
import com.sda.todo.model.TodoStatus;
import com.sda.todo.model.TodoUser;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TodoConsoleView {
    private Scanner scanner;

    public TodoConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer menu() {
        System.out.println("**********************");
        System.out.println("Todo application");
        System.out.println("**********************");
        System.out.println("1. Zaloguj");
        System.out.println("2. Zarejestruj");
        System.out.println("3. Dodaj zadanie");
        System.out.println("4. Wyświetl zadania");
        System.out.println("0. Koniec");

        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }


    public String logInName() {
        System.out.println("Podaj nick");
        return scanner.nextLine();
    }

    public String logInPassword() {
        System.out.println("Podaj hasło");
        return scanner.nextLine();
    }

    public String registerName() {
        return logInName();
    }

    public String registerPassword() {
        return logInPassword();
    }

    public String createNewTodoNanme() {
        System.out.println("Podaj nazwę zadania");
        return scanner.nextLine();
    }

    public String createNewTodoDescription() {
        System.out.println("Podaj opis zadania");
        return scanner.nextLine();
    }

    public void displayError(String message) {
        System.out.println();
        System.out.println("ERROR");
        System.out.println(message);
        System.out.println("ERROR");
        System.out.println();
    }

    public void displaySuccess(String message) {

        System.out.println();
        System.out.println("SUCCESS");
        System.out.println(message);
        System.out.println("SUCCESS");
        System.out.println();
    }

    public void exit() {
        System.out.println("Zapraszamy ponownie");
    }

    public Integer showTodoListWithOptions(List<Todo> allTodo) {
        System.out.println("Lista zadań");
        System.out.println("-----------");
        for (int i = 0; i < allTodo.size(); i++) {
            Todo todo = allTodo.get(i);
            TodoUser creator = todo.getCreator();
            Optional<TodoUser> owner = Optional.ofNullable(todo.getOwner());
            TodoStatus todoStatus = todo.getTodoStatus();
            System.out.println((i + 1 + ". | \"" + todo.getName() +
                    "\" | \"" + creator.getName() +
                    "\" | \"" + owner.orElse(TodoUser.unassigned()).getName() +
                    "\" | " + todoStatus.toString().toUpperCase()));
        }
        System.out.println("------------");
        System.out.println("1. Wyświetl");
        System.out.println("2. Usuń");
        System.out.println("3. Przypisz");
        System.out.println("4. Zmień status");
        System.out.println("0. Wyjdź");

        Integer option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }
}
