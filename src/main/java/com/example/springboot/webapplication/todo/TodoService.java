package com.example.springboot.webapplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    //1.list 로 투두리스트 담음
    private static List<Todo> todos= new ArrayList<>();//2. 정적 리스트로 변환
    //3. 정적 변수를 초기화할때는 static블록을 만들어야 함
    static {
        todos.add(new Todo(1,"moya","Learn Java",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2,"yheon","LearnMSA",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3,"yeon","Learn JWT",
                LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findByUserName(String username){
        return todos;
    }
}
