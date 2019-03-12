package com.lemmeknow.controller;

import com.lemmeknow.model.User;
import com.lemmeknow.model.dto.UserGetDTO;
import com.lemmeknow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserGetDTO> getAll(){
        List<UserGetDTO> response = new ArrayList<>();
        userService.getAll().forEach(
                allUsersList->response.add(modelMapper.map(allUsersList,UserGetDTO.class)));

        return response;
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public UserGetDTO getUserById(@PathVariable int userId){

        UserGetDTO result = modelMapper.map(userService.getById(userId), UserGetDTO.class);

        return result;
    }

    @PostMapping(value = "/create")
    public void createEvent(@RequestBody UserGetDTO newUser) {
        User u = userService.createUser(modelMapper.map(newUser,User.class));
    }

    @PutMapping(value = "/update/{eventId:\\d+}")
    public void updateEvent(@PathVariable int eventId,@RequestBody UserGetDTO updatedUser) {
        userService.updateUser(eventId, modelMapper.map(updatedUser,User.class));
    }

    @DeleteMapping(value = "/delete/{eventId:\\d+}")
    public void deleteEvent(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}