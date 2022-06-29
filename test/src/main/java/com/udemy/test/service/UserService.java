package com.udemy.test.service;

import com.udemy.test.domain.User;
import com.udemy.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void joinUser(User user) {
        userRepository.save(user);
    }

    public User getUserOne(Long userSeq) {
        User user =  userRepository.findById(userSeq).orElseThrow(()->new IllegalArgumentException("해당 번호의 user가 없습니다."));
        System.out.println(user);
        return user;
    }


    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void updateUser(Long userSeq, User user) {
        User updateUser = userRepository.findById(userSeq).orElseThrow(()->new IllegalArgumentException("해당 번호의 user가 없습니다. "));
        updateUser.setEmail(user.getEmail());
        updateUser.setId(user.getId());
        updateUser.setPwd(user.getPwd());
        updateUser.setName(user.getName());
        userRepository.save(updateUser);
    }

    public void deleteUser(Long userSeq) {
        User user = userRepository.findById(userSeq).orElseThrow(()-> new IllegalArgumentException("해당 번호의 user가 없습니다."));
        userRepository.delete(user);
    }
}
