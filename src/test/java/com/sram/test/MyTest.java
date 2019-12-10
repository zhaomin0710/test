package com.sram.test;

import com.sram.MyApp;
import com.sram.common.CodeMenu;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApp.class)
public class MyTest {
    @Autowired
    private UserService userService;
    @Test
    public void findAll(){
        Page<User> userPage = userService.findAll(new PageRequest(1, 5));
        userPage.getSize();
        System.out.println("----------------"+userPage.getContent());
    }
    @Test
    public void CodeMenuTest(){
        CodeMenu codeMenu = CodeMenu.SUCCESS;
        codeMenu.getCode();
//        System.out.println(CodeMenu.SUCCESS.isSuccess()+"---"+CodeMenu.FAIL.getCode());
    }
    @Test
    public void findById(){
        User user = userService.findById(1);
        System.out.println(user);
    }
}
