package com.udemy.test.controller;

import com.udemy.test.domain.User;
import com.udemy.test.dto.JsonResponse;
import com.udemy.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping("/joinUser")
    public ResponseEntity<?> joinUser(@RequestBody User user){
        userService.joinUser(user);

        return ResponseEntity.ok(new JsonResponse(200,"joinUser", null));
    }

    //read
    @GetMapping("/getUser/{userSeq}")
    @ResponseBody
    public ResponseEntity<?> getUserOne(@PathVariable Long userSeq){
        User user =  userService.getUserOne(userSeq);
        return ResponseEntity.ok(new JsonResponse(200,"getUserOne", user));
    }

    @GetMapping("/getUserList")
    @ResponseBody
    public ResponseEntity<?> getUserList(){
        List<User> userList = userService.getUserList();
        return ResponseEntity.ok(new JsonResponse(200,"getUserList", userList));
    }

    //update
    @PostMapping("/updateUser/{userSeq}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable Long userSeq){
        userService.updateUser(userSeq,user);
        return ResponseEntity.ok(new JsonResponse(200,"updateUser", null));
    }

    //delete
    @DeleteMapping("/deleteUser/{userSeq}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userSeq){
        userService.deleteUser(userSeq);
        return ResponseEntity.ok(new JsonResponse(200,"deleteUser", null));
    }
}
