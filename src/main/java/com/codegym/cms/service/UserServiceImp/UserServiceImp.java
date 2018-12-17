package com.codegym.cms.service.UserServiceImp;

import com.codegym.cms.model.User;
import com.codegym.cms.repository.UserRepository;
import com.codegym.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
