package com.raj.DataBaseOneOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserDetailsMapper userDetailsMapper = new UserDetailsMapper();

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
        //@ResponseBody
    UserDto findAllUsers() {
      return userMapper.mapToDto(userRepository.findAll().iterator().next());

    }

}
