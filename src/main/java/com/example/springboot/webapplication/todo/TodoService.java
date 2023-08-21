package com.example.springboot.webapplication.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    //1.list 로 투두리스트 담음
    private static List<Todo> todos= new ArrayList<>();//2. 정적 리스트로 변환
    //3. 정적 변수를 초기화할때는 static블록을 만들어야 함
    private static int todosCount=0;

    static {
        todos.add(new Todo(++todosCount,"moya","Get Learn Java",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount,"yheon","LearnMSA",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount,"yeon","Learn JWT",
                LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findByUserName(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo= new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }
    public void deleteById(int id){

        Predicate<? super Todo> predicate = todo->todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo->todo.getId()==id;
        Todo todo= todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
