package com.sram.service;

import com.sram.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface UserService {
    public Page<User> findAll(Pageable pageable);
    public User findById(Integer userId);
    public void update(User user);
    public Page<User> search(String str,Pageable pageable);
}
