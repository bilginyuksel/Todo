package com.bilginyuksel.todo.endpoint;

import com.bilginyuksel.todo.exception.UserAuthenticationTokenException;
import com.bilginyuksel.todo.model.Category;
import com.bilginyuksel.todo.model.User;
import com.bilginyuksel.todo.repository.CategoryRepository;
import com.bilginyuksel.todo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/category")
public class CategoryResource {

    @Autowired private CategoryRepository categoryRepository;
    @Autowired private AuthenticationService authenticationService;

    @PostMapping("/category")
    public Category createCategory(@RequestHeader String Authorization,
                                   @RequestParam String title,
                                   @RequestParam(defaultValue = "") String description)
    {

        try{
            User user = authenticationService.findAlreadyLoggedUser(Authorization);

            Category category = new Category(title);
            category.setUser(user);
            category.setDescription(description);
            categoryRepository.save(category);

            return category;
        }catch (UserAuthenticationTokenException e){
            // You can make this method String and print the exception message.
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/categories")
    public List<Category> getCategories(@RequestHeader String Authorization){

        try{
            User user = authenticationService.findAlreadyLoggedUser(Authorization);
            List<Category> categories = categoryRepository.findAllByUser(user);
            return categories;

        }catch (UserAuthenticationTokenException e){
            e.printStackTrace();
            return null;
        }
    }


}
