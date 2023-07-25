package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /** 생성 */
    @Transactional
    public void saveUser(UserCreateRequest request){
        User user = userRepository.save(new User(request.getName(), request.getAge()));
        user.getId();
    }

    /** 조회 */
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    /** 수정 */
    @Transactional
    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        user.updateName(request.getName());
        // 영속성 컨텍스트로 인한 save 없이 저장 기능 활성화 ( Transactional )
        // userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name){
//        User user = userRepository.findByName(name);
//        if(user == null){
//            throw new IllegalArgumentException();
//        }
        if (!userRepository.existsByName(name)){
            throw new IllegalArgumentException();
        }

        User user = userRepository.findByName(name);

        userRepository.delete(user);
    }
}
