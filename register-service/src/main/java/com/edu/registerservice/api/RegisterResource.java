package com.edu.registerservice.api;

import com.edu.registerservice.common.TransactionRequest;
import com.edu.registerservice.common.TransactionResponse;
import com.edu.registerservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterResource {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/studentRegister")
    public TransactionResponse studentRegister(@RequestBody TransactionRequest request) {
        return registerService.saveRegister(request);
    }
}
