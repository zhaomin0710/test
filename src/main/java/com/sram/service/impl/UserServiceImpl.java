package com.sram.service.impl;

import com.sram.dao.UserDao;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(Integer userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public Page<User> search(String str, Pageable pageable) {
        Specification<User> userSpecification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path username = root.get("username");
                Predicate predicate1 = criteriaBuilder.like(username, "%"+str+"%");
                Path email = root.get("email");
                Predicate predicate2 = criteriaBuilder.like(email, "%"+str+"%");
                Predicate predicate = criteriaBuilder.or(predicate1, predicate2);
                return predicate;
            }
        };
        return userDao.findAll(userSpecification, pageable);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
