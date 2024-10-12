package com.factory.heading.controller.api2;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.factory.heading.models.Role;
import com.factory.heading.models.User;
import com.factory.heading.security.config.PBKDF2PasswordEncoder;
import com.factory.heading.security.detail.UserDetailServiceImpl;
import com.factory.heading.security.jwt.JwtUtils;
import com.factory.heading.service.RoleService;
import com.factory.heading.service.UserService;
import com.factory.heading.utils.automation.CreateSku;
import com.factory.heading.utils.request.LoginRequest;
import com.factory.heading.utils.request.SignupRequest;
import com.factory.heading.utils.response.LoginResponse;
import com.factory.heading.utils.response.SignupResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RestLoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PBKDF2PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody LoginRequest loginRequest) {
        try {
            // xác thực người dùng
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), 
                    loginRequest.getPassword()
                )
            );

            // thiết lập security text
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.createToken(
                userDetailService.loadUserByUsername(loginRequest.getUsername())
            );
            return new LoginResponse(loginRequest.getUsername(), jwt);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> postMethodName(@RequestBody SignupRequest signupRequest) {
        try {
            // check username has already registered
            if (userService.findByUsername(signupRequest.getUsername()) != null) {
                return ResponseEntity
                        .status(409)
                        .body(new SignupResponse(409, "Error: Username is already taken!"));
            }

            // check role is existed
            Role role = roleService.findById(signupRequest.getRoleId());
            if (role == null) {
                return ResponseEntity
                        .status(404)
                        .body(new SignupResponse(404, "Error: Role not found!"));
            }

            // create a sku
            String SKU = signupRequest.getSku() == null ? CreateSku.random() : signupRequest.getSku();

            // create a new user
            User user = new User();
            user.setUniqueId(java.util.UUID.randomUUID().toString());
            user.setSKU(SKU);
            user.setFullname(signupRequest.getFullname());
            user.setUsername(signupRequest.getUsername());
            user.setActivated(signupRequest.getActivated());
            user.setCreatedAt(LocalDateTime.now());
            user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            user.setRole(role);

            // add user into database
            userService.save(user);

            return ResponseEntity
                    .ok(new SignupResponse(200, "Signup thành công !"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body(new SignupResponse(404, e.getMessage()));
        }
    }
    
}
