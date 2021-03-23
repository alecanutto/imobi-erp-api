package com.acanuto.imobi.erp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.LoginDTO;
import com.acanuto.imobi.erp.dto.response.ResponseLoginDTO;
import com.acanuto.imobi.erp.repository.UserRepository;
import com.acanuto.imobi.erp.security.jwt.JwtUtils;
import com.acanuto.imobi.erp.security.service.UserDetailsImpl;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired(required = true)
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping()
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {

		try {
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDTO.getUsuario(), loginDTO.getSenha()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
					
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			String expiration = jwtUtils.getExpirationDateFromToken(jwt);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
												
			return ResponseEntity.ok(new ResponseLoginDTO(jwt, expiration, userDetails.getId(), userDetails.getUsername(), roles));
			
		} catch (Exception e) {
			System.out.println("erro: " + e.getMessage());
		}
		
		return null;
	}
	
}
