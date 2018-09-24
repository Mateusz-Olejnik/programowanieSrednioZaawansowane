package com.sda.todo;

import com.sda.todo.model.Todo;
import com.sda.todo.model.TodoUser;
import com.sda.todo.repository.TodoRepository;
import com.sda.todo.repository.TodoUserRepository;
import com.sda.todo.repository.memory.InMemoryTodoRepository;
import com.sda.todo.repository.memory.InMemoryTodoUserRepository;
import com.sda.todo.service.TodoService;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@AllArgsConstructor
public class TodoApplication {

    private TodoService todoService;
    private TodoConsoleView todoConsoleView;
    private TodoUser currentUser;


    public static void main(String[] args) {
        TodoRepository todoRepository = new InMemoryTodoRepository();
        TodoUserRepository todoUserRepository = new InMemoryTodoUserRepository(Arrays.asList(new TodoUser("mat", "ole")));
        TodoService todoService = new TodoService(todoRepository, todoUserRepository);

        Scanner scanner = new Scanner(System.in);
        TodoConsoleView todoConsoleView = new TodoConsoleView(scanner);

        TodoApplication todoApplication = new TodoApplication(todoService, todoConsoleView,null);
        todoApplication.start();
    }

    public void start() {
        TodoUser currentUser = null;
        do {
            Integer menuOption = todoConsoleView.menu();
            switch (menuOption) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    addNewTodo();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (true);

    }

    private void addNewTodo(){
        if(currentUser == null){
            String name = todoConsoleView.logInName();
            String password = todoConsoleView.logInPassword();
            this.currentUser = todoService.login(name, password);
        }
        String todoName = todoConsoleView.createNewTodoNanme();
        String todoDescription = todoConsoleView.createNewTodoDescription();
        Todo todo = new Todo(todoName, this.currentUser);
        todo.setDescrtiption(todoDescription);

        todoService.save(todo);
    }
}
