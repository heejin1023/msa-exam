package com.sparta.msaexam.gateway;

import com.sparta.msaexam.gateway.service.AuthService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "auth-service")
public interface AuthClient extends AuthService {

    @GetMapping("auth-verify")
    Boolean verifyUserAuth(@RequestParam("user_id") String userId);

}
