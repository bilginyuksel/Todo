package com.bilginyuksel.todo.Preparation;

import com.bilginyuksel.todo.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public class TestPreperationManagerImpl implements TestPreperationManager{

    @Override
    public void registerUsersToApplication(UserService service, UserTestPreparation userTestPreparation){
        if(userTestPreparation.isFirstUserEnabled())
            service.register(
                    userTestPreparation.getUser1().getUsername(),
                    userTestPreparation.getUser1().getPassword(),
                    userTestPreparation.getUser1().getEmail());

        if(userTestPreparation.isSecondUserEnabled())
            service.register(
                    userTestPreparation.getUser2().getUsername(),
                    userTestPreparation.getUser2().getPassword(),
                    userTestPreparation.getUser2().getEmail());

        if(userTestPreparation.isThirdUserEnabled())
            service.register(
                    userTestPreparation.getUser3().getUsername(),
                    userTestPreparation.getUser3().getPassword(),
                    userTestPreparation.getUser3().getEmail());
    }

    @Override
    public void saveEntityToApplication(JpaRepository repository, Object obj) {
        repository.save(obj);
    }

}
