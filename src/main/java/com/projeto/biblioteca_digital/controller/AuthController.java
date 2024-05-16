package com.projeto.biblioteca_digital.controller;

import com.projeto.biblioteca_digital.dto.LoginRequestDTO;
import com.projeto.biblioteca_digital.dto.ResponseDTO;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.repository.UserRepository;
import com.projeto.biblioteca_digital.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User Not Found!"));

        if(passwordEncoder.matches(body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserForm body){
        Optional<User> user = this.userRepository.findByEmail(body.getEmail());
        if(user.isEmpty()){
            User newUser = new User();
            newUser.setUsername(body.getUsername());
            newUser.setCpf(body.getCpf());
            newUser.setEmail(body.getEmail());
            newUser.setPassword(passwordEncoder.encode(body.getPassword()));
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
