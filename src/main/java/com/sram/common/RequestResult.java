package com.sram.common;

import com.sram.entity.User;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@ToString
public class RequestResult<T> {
    private CodeMenu codeMenu;
    private T user;
    private Page<User> userPage;

    public RequestResult(CodeMenu codeMenu) {
        this.codeMenu = codeMenu;
    }

    public CodeMenu getCodeMenu() {
        return codeMenu;
    }

    public RequestResult<T> setCodeMenu(CodeMenu codeMenu) {
        this.codeMenu = codeMenu;
        return this;
    }

    public T getUser() {
        return user;
    }

    public RequestResult<T> setUser(T user) {
        this.user = user;
        return this;
    }

    public Page<User> getUserPage() {
        return userPage;
    }

    public RequestResult<T> setUserPage(Page<User> userPage) {
        this.userPage = userPage;
        return this;
    }
}
