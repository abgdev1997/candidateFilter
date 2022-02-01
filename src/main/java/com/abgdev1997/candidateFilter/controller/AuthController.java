package com.abgdev1997.candidateFilter.controller;

import com.abgdev1997.candidateFilter.dto.LoginDTO;
import com.abgdev1997.candidateFilter.dto.MessageDTO;
import com.abgdev1997.candidateFilter.dto.RegisterDTO;
import com.abgdev1997.candidateFilter.models.User;
import com.abgdev1997.candidateFilter.repository.UserRepository;
import com.abgdev1997.candidateFilter.security.jwt.JwtTokenUtil;
import com.abgdev1997.candidateFilter.security.payload.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<MessageDTO> register(@RequestBody RegisterDTO signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageDTO("ERROR: The username exists"));
        }
        if (userRepository.existsByEnterpriseEmail(signUpRequest.getEnterpriseEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageDTO("ERROR: The email exists"));
        }
        User newUser = new User(
                null,
                signUpRequest.getUserName(),
                signUpRequest.getName(),
                signUpRequest.getEnterpriseEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(newUser);

        return ResponseEntity.ok(new MessageDTO("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDTO loginUser) {
        Optional<User> userDB;
        if (userRepository.existsByEnterpriseEmail(loginUser.getEnterpriseEmail())) {
            userDB = userRepository.findByEnterpriseEmail(loginUser.getEnterpriseEmail());
            if(userDB.isPresent()) {
                String userName = userDB.get().getUserName();
                Authentication authentication = authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userName, loginUser.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtTokenUtil.generateJwtToken(authentication);
                return ResponseEntity.ok(new JwtResponse(jwt));
                }
            }
        return ResponseEntity.badRequest().build();
    }
}
