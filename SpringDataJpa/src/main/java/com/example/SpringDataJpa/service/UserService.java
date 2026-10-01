package com.example.SpringDataJpa.service;
import com.example.SpringDataJpa.entites.User;
import com.example.SpringDataJpa.Reposatiary.UserRepositary;
import com.example.SpringDataJpa.dto.CreateUserdto;
import com.example.SpringDataJpa.dto.UserDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;



import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepositary userRepositary;



    public UserDto saveUser(CreateUserdto createUserdto) {
        User userobj = new User();
        userobj.setEmail(createUserdto.getEmail());
        userobj.setName((createUserdto.getName()));

        User savedUser = userRepositary.save(userobj);

        return new UserDto(savedUser.getId(),savedUser.getName(),savedUser.getEmail());
    }

    public UserDto getUserById(Long id) {
        User user = userRepositary.findById(id).orElseThrow();
       return new UserDto(user.getId(),user.getName(),user.getEmail());
    }
@Transactional
    public UserDto patchUser(Long id, CreateUserdto patchUserDto) {
            User user = userRepositary.findById(id).orElseThrow();
            if(patchUserDto.getName()!= null){
                user.setName(patchUserDto.getName());}
            if(patchUserDto.getEmail()!= null){
                user.setEmail(patchUserDto.getEmail());}
            return new UserDto(user.getId(),user.getName(),user.getEmail());

    }

    public List <UserDto> getUsers() {
        List<User> users = new ArrayList<>();
       users = userRepositary.findAll(); //database sa sara data nikal kr users name ki list ma rkh dia h
        List<UserDto>userDtoList = new ArrayList<>(); //DTO objects ko store krne ka lia ak khali list bnata hn
        for (User user: users){//loop chla ka ak ak krke sara data bari bari pick kr rha hn
            UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail()); // name, id , email nikal kr teeno ka new UserDto object bnata h taki sensitive content hide kia jaye.
            userDtoList.add(userDto); //DTO object ko apni ready kri hui userDtoList ma dala jata hn
        }
        return userDtoList;

    }

//    public UserDto updateUser(Long id, CreateUserdto updateUserDto) {
//
//    }
}
