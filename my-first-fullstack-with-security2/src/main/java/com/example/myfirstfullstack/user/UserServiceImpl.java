package com.example.myfirstfullstack.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        passwordEncoder
                = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this();
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Boolean validateUser(String username, String password) {

        User existingUser = userRepository.findByUsername(username);

        if (existingUser == null) {
            throw new UserNotFoundException("User does not exist with Username: " + username);
        }

        boolean isValid =
                (username.equals(existingUser.getUsername()) &&
                password.equals(existingUser.getPassword()));

        return isValid;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null) {
            throw new UserNotFoundException("User does not exist with Username: " + user.getUsername());
        }

        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            throw new UserNotFoundException("User does not exist with Username: " + username);
        }

        userRepository.delete(existingUser);
    }

}
