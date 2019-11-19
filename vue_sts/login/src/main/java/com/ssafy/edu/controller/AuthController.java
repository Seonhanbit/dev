package com.ssafy.edu.controller;

import com.ssafy.edu.exception.AppException;
import com.ssafy.edu.help.ApiResult;
import com.ssafy.edu.help.JwtAuthenticationResult;
import com.ssafy.edu.help.LoginRequest;
import com.ssafy.edu.help.SignUpRequest;
import com.ssafy.edu.model.Role;
import com.ssafy.edu.model.RoleName;
import com.ssafy.edu.model.MemberUser;
import com.ssafy.edu.repository.RoleRepository;
import com.ssafy.edu.repository.UserRepository;
import com.ssafy.edu.security.JwtTokenProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    	logger.info("1-------------authenticateUser-----------------------------"+loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResult(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody SignUpRequest signUpRequest) {
    	logger.info("1-------------registerUser-----------------------------"+signUpRequest);
    	if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResult(false, "사용자 아이디가 이미 존재합니다!"),
                    HttpStatus.BAD_REQUEST);
        }
    	logger.info("2-------------registerUser-----------------------------"+signUpRequest);
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResult(false, "이메일이 이미 존재합니다!"),
                    HttpStatus.BAD_REQUEST);
        }
        logger.info("3-------------registerUser-----------------------------"+signUpRequest);
        // Creating user's account
        MemberUser user = new MemberUser(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());
        logger.info("4-------------registerUser-----------------------------"+user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        //logger.info("4-------------registerUser-----------------------------"+userRole);
        user.setRoles(Collections.singleton(userRole));
       
        MemberUser result = userRepository.save(user);
        //logger.info("5-------------registerUser-----------------------------"+result);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResult(true, "성공적으로 등록되었습니다."));
    }
}
