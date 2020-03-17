package com.raj.DataBaseOneOne;

import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {


    public UserDetailsDto mapToDto(UserDetails userDetails) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setUserId(userDetails.getUser().getId());

//        userDetails.forEach(u -> userDetailsDto.setUserId(u.getUserDetails().getUser().getId()));
//        userDetails.forEach(u -> userDetailsDto.setId(u.getUserDetails().getId()));
//        userDetails.forEach(u -> userDetailsDto.setAddress(u.getUserDetails().getAddress()));
//        userDetails.forEach(u -> userDetailsDto.setPesel(u.getUserDetails().getPesel()));
        return userDetailsDto;
    }
}
