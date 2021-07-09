package com.example.simplecrud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).get();
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path="/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping(path="/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId, @Valid @RequestBody User userData) {
        User user = userRepository.findById(userId).get();
        user.setName(userData.getName());
        user.setSurname(userData.getSurname());
        user.setEmail(userData.getEmail());
        final User userUpdated = userRepository.save(user);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping(path="users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}