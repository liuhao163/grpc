package com.ericliu.grpc.client.controller;

import com.ericliu.grpc.client.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app-users")
public class AppUserApi {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{userName}")
    public String getByName(@PathVariable String userName) {
        return appUserService.getByName(userName);
    }
}
