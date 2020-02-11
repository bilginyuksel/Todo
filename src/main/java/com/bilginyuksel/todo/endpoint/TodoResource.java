package com.bilginyuksel.todo.endpoint;

import com.bilginyuksel.todo.exception.UserAuthenticationTokenException;
import com.bilginyuksel.todo.model.ShareTodo;
import com.bilginyuksel.todo.model.Todo;
import com.bilginyuksel.todo.model.User;
import com.bilginyuksel.todo.repository.CategoryRepository;
import com.bilginyuksel.todo.repository.ShareTodoRepository;
import com.bilginyuksel.todo.repository.TodoRepository;
import com.bilginyuksel.todo.repository.UserRepository;
import com.bilginyuksel.todo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/todo")
public class TodoResource {

    @Autowired private ShareTodoRepository shareTodoRepository;
    @Autowired private AuthenticationService authenticationService;
    @Autowired private TodoRepository todoRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private UserRepository userRepository;

    
    @PostMapping("/todo")
    public Todo insertTodo(@RequestHeader String Authorization,
                           @RequestParam(defaultValue = "-") String title,
                           @RequestParam String content,
                           @RequestParam(defaultValue = "1") Integer categoryId /*or category name*/){

        try {
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            Todo todo = new Todo(title, content);
            todo.setUser(user);
            todo.setLastUpdateDate(new Date());

            todoRepository.save(todo);

            return todo;
        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @PutMapping("/todo")
    public String updateTodo(@RequestHeader String Authorization,
                             @RequestParam Integer todoId,
                             @RequestParam(defaultValue = "aosd*11239asdnadsnf1") String title,
                             @RequestParam(defaultValue = "aosd*11239asdnadsnf1") String content,
                             @RequestParam(defaultValue = "aosd*11239asdnadsnf1") String categoryId){

        try {
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            // Check this user's permission and if you approve continue process.

            Optional<Todo> optionalTodo = todoRepository.findTodoByIdAndUser(todoId, user);
            if(optionalTodo.isPresent()){
                Todo todo = optionalTodo.get();
                todo.setLastUpdateDate(new Date());
                if(!title.equals("aosd*11239asdnadsnf1")) todo.setTitle(title);
                if(!content.equals("aosd*11239asdnadsnf1"))todo.setContent(content);
                if(!categoryId.equals("aosd*11239asdnadsnf1")) todo.setCategory(categoryRepository.findById(Integer.parseInt(categoryId)).get());
                // do this for category.
                todoRepository.save(todo);
                return "Successfully Completed!";
            }else return "Todo not found!";



        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
            return "Wrong user credentials.";
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @DeleteMapping("/todo")
    public String deleteTodo(@RequestHeader String Authorization,
                             @RequestParam Integer todoId){

        try {
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            todoRepository.deleteTodoByIdAndUser(todoId, user);
            return "Todo Deleted Successfully!";
        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
            return "Something went wrong with the authentication !";
        }


    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos(@RequestHeader String Authorization){
        try {
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            return todoRepository.findAllByUser(user);
        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/todo-details")
    public Todo details(@RequestHeader String Authorization,
                        @RequestParam Integer todoId)
    {
        try {
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            Optional<Todo> optionalTodo = todoRepository.findTodoByIdAndUser(todoId, user);

            if(!optionalTodo.isPresent()) return null;

            // You can check user's permission here.
            return optionalTodo.get();

        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/category/todos")
    public List<Todo> getTodosByCategory(@RequestHeader String Authorization,
                                         @RequestParam Integer categoryId)
    {
        // Make this method rock solid.
        User user = null;
        try {
            user = authenticationService.findAlreadyLoggedUser(Authorization);
            return todoRepository.findAllByUserAndCategory(user, categoryRepository.findById(categoryId).get());
        } catch (UserAuthenticationTokenException e) {
            e.printStackTrace();
        }

        return null;
    }


    @PostMapping("/share-todo")
    public String createSharedTodoUrl(@RequestHeader String Authorization,
                                      @RequestParam Integer todoId,
                                      @RequestParam Integer userId){



        try{
            // Find authorized user's todos and share with the mentioned user.
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            Optional<Todo> optionalTodo = todoRepository.findTodoByIdAndUser(todoId, user);

            if(!optionalTodo.isPresent()) return "Todo can't found.";

            Optional<User> optionalUser = userRepository.findById(userId);
            if(!optionalUser.isPresent()) return "No user to share.";

            ShareTodo shareTodo = new ShareTodo(optionalUser.get(), optionalTodo.get());
            shareTodo.setUrl(optionalTodo.get().generateUrl());
            shareTodoRepository.save(shareTodo);

            return shareTodo.getUrl();


        }catch (UserAuthenticationTokenException e){
            e.printStackTrace();
            return "User Authentication went wrong.";
        }

    }

    // Shared todos source
    // Make custom this thing.
    @GetMapping("/share-{token}")
    public Todo getSharedTodoSource(@RequestHeader String Authorization,
                                 @PathVariable String token){

        try{
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            // Match this user with the token owner
            Optional<ShareTodo> optionalShareTodo = shareTodoRepository.findShareTodoByToken(token);

            if(!optionalShareTodo.isPresent()) return null;
            ShareTodo shareTodo = optionalShareTodo.get();
            if (shareTodo.getSharedTo() == user) return shareTodo.getTodo();
            return null; // Throw you're not authorized for that action.

        }catch (UserAuthenticationTokenException e){
            e.printStackTrace();
        }
        return null;
    }
}
