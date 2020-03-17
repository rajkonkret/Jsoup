package com.raj.DataBaseOneOne;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setUserDetailsId(user.getUserDetails().getUser().getId());
        return userDto;
    }
}
