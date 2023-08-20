package com.example.springboot.webapplication.todo;

import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;


    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos =todoService.findByUserName("moya");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    //GET,POST나눠서 매핑하기
    //GET 매핑
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username=(String)model.get("name");
        Todo todo= new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    //POST매핑
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username=(String)model.get("name");
        todoService.addTodo(username, todo.getDescription(),
        LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }
}
