package com.sram.controller;

import com.sram.common.CodeMenu;
import com.sram.common.RequestResult;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public RequestResult<User> findAll(Pageable pageable){
        RequestResult<User> result = new RequestResult<>(CodeMenu.SUCCESS);
        result.setUserPage(userService.findAll(pageable));
        return result;
    }
    @RequestMapping("/findById")
    public RequestResult<User> findById(Integer userId){
        RequestResult<User> result = new RequestResult<>(CodeMenu.SUCCESS);
        result.setUser(userService.findById(userId));
        return result;
    }
    @RequestMapping("/update")
    public void update(@RequestBody User user){
        System.out.println("******************"+user);
        if (user.getId() != null){
            userService.update(user);
        }
    }
    @RequestMapping("/search")
    public RequestResult<User> search(String str,Pageable pageable){
        RequestResult<User> result = new RequestResult<>(CodeMenu.SUCCESS);
        result.setUserPage(userService.search(str,pageable));
        return result;
    }
}
