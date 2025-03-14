package com.socialmediaapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialmediaapp.Entity.User;
import com.socialmediaapp.exception.UserException;

@Service
public interface UserService {

    public User registerUser(User user);

    public User findUserById(int userId) throws UserException;

    public User findUserByEmail(String email);

    public User followUser(int userId1, int userId2) throws UserException;

    public User updateUser(User user, int userId) throws UserException;

    public List<User> searchUser(String query);

    public List<User> getAllUsers();

    public User findUserByJwt(String jwt);
}
