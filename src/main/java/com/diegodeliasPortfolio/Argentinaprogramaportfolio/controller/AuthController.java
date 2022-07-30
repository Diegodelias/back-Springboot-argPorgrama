package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import org.springframework.web.bind.annotation.RestController;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.AuthRequest;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.util.JwUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="https://porfolioargprogramadiegodelias.web.app")
public class AuthController {

    
    @Autowired
    private JwUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }
  
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            System.out.println("USUARIO" + authRequest.getUserName());
            System.out.println("PASSWORD" + authRequest.getPassword());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
    
}
