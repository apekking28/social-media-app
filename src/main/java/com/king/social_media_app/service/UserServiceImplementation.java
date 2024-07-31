package com.king.social_media_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.social_media_app.models.User;
import com.king.social_media_app.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserById(Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }

        throw new Exception("User not exist with id " + id);
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public User followUser(Integer userId1, Integer userId2) throws Exception {
        
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        user2.getFollowers().add(user1.getId());
        user1.getFollowings().add(user2.getId());

        userRepository.save(user1);
        userRepository.save(user2);

        return user1;
    }

    @Override
    public User registerUser(User user) {
        
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        User savedUser = userRepository.save(newUser);

        return savedUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User updateUser(User user, Integer userId) throws Exception {
        Optional<User> user1 = userRepository.findById(userId);

        if(user1.isEmpty()) {
            throw new Exception("User not exist with id " + userId);
        }

        User oldUser = user1.get();

        if(user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }

        if(user.getFirstName() != null) {
            oldUser.setLastName(user.getFirstName());
        }

        if(user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }

        User updatedUser = userRepository.save(oldUser);

        return updatedUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
