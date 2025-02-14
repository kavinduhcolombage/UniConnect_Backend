package com.USJ.UniConnect_Backend.controller;

import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.exception.UserNotFoundException;
import com.USJ.UniConnect_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usercontroller")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService  = userService ;
    }



    @GetMapping(value = "{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getSelectedUser(@PathVariable String userId){
        try {
            return ResponseEntity.ok(userService.getSelectedUser(userId));
        }
        catch (UserNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }





}



