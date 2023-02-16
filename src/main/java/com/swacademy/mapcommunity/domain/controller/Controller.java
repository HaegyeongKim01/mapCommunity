package com.swacademy.mapcommunity.domain.controller;

import com.swacademy.mapcommunity.domain.ApiResponse;
import com.swacademy.mapcommunity.domain.dto.UserDto;
import com.swacademy.mapcommunity.domain.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @ExceptionHandler(NotFoundException.class)
    public ApiResponse<String> notFoundHandler (NotFoundException e) {
        return ApiResponse.fail(404, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> internalServerErrorHandler (Exception e) {
        return ApiResponse.fail(500, e.getMessage());
    }

    @PostMapping("/user")
    public ApiResponse<UUID> save(@RequestBody UserDto userDto) {
        UUID uuid = userService.save(userDto);
        return ApiResponse.ok(uuid);
    }

}
