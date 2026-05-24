package com.example.controller;

import com.example.DTO.DadosLogin;
import com.example.DTO.DadosTokenJwt;
import com.example.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJwt> login(
            @RequestBody @Valid DadosLogin dados) {

        var authToken = new UsernamePasswordAuthenticationToken(
                dados.email(), dados.senha());

        var auth = authenticationManager.authenticate(authToken);
        var token = jwtService.gerarToken(auth.getName());

        return ResponseEntity.ok(new DadosTokenJwt(token));
    }
}
