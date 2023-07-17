package com.group.libraryapp.service;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(),request.getAge());
    }

    public void updateUser (UserUpdateRequest request) {
        boolean isUserNotExist = userRepository.isUserNotExist(request.getId());

        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getName(), request.getId() );
    }

    public List<UserResponse> getUsers(){
        return  userRepository.getUsers();
    }

    public void deletUser(String name){
        boolean isUserNotExist = userRepository.isUserNotExist(name);

        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);

    }


}
