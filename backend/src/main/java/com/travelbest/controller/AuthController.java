package com.travelbest.controller;

import com.travelbest.entity.Role;
import com.travelbest.entity.User;
import com.travelbest.exception.InvalidPasswordException;
import com.travelbest.exception.UserNotFoundException;
import com.travelbest.security.auth.JwtAuthenticationRequest;
import com.travelbest.security.auth.JwtAuthenticationResponse;
import com.travelbest.security.auth.JwtTokenUtil;
import com.travelbest.security.auth.JwtUser;
import com.travelbest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController extends BaseController {

    @Value("${auth.header}")
    private String tokenHeader;

    public static final String SIGN_IN_URL = "api/auth/signin";
    public static final String SIGN_UP_URL = "api/auth/signup";
    public static final String REFRESH_TOKEN_URL = "api/auth/token/refresh";

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;
    private UserService userService;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping(AuthController.SIGN_UP_URL)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
            throws AuthenticationException {

        String name = authenticationRequest.getUsername();
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();
        LOG.info("[POST] CREATING TOKEN FOR User " + name);
        Role role  = new Role("USER");
        userService.save(new User(name, email, password, role));
        JwtUser userDetails;
        try {
            userDetails = (JwtUser) this.userDetailsService.loadUserByUsername(name);
        } catch (UsernameNotFoundException ex) {
            LOG.error(ex.getMessage());
            throw new UserNotFoundException();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(name, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @PostMapping(AuthController.SIGN_IN_URL)
    public ResponseEntity<?> getAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
            throws AuthenticationException {

        String name = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        LOG.info("[POST] GETTING TOKEN FOR User " + name);
        JwtUser userDetails;
        try {
            userDetails = (JwtUser) userDetailsService.loadUserByUsername(name);
        } catch (UsernameNotFoundException | NoResultException ex) {
            LOG.error(ex.getMessage());
            throw new UserNotFoundException();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
        if(!passwordEncoder().matches(password, userDetails.getPassword())) {
            throw new InvalidPasswordException();
        }
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(name, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @PostMapping(AuthController.REFRESH_TOKEN_URL)
    public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        LOG.info("[POST] REFRESH TOKEN FOR User " + token);
        String refreshedToken = jwtTokenUtil.refreshToken(token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    }

}
