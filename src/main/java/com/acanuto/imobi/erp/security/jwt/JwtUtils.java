package com.acanuto.imobi.erp.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.security.service.UserDetailsImpl;
import com.acanuto.imobi.erp.util.Function;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	private static final String SECRET_KEY = "ACIMOBI_SECRET_KEY";
	private static final int EXPIRATION_MS = 14400000;

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

		String token = Jwts.builder().setSubject((user.getUsername())).claim("authorities", user.getAuthorities())
				.setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + EXPIRATION_MS))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();

		return token;

	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	public String getExpirationDateFromToken(String token) {
		try {
			return Function.formatDateTime(
					Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration(),
					"dd/MM/yyyy HH:mm:ss");
		} catch (Exception e) {
			logger.error("Error getExpirationDateFromToken: ", e.getMessage());
		}
		return "";
	}

//	private boolean isTokenExpired(String token) {
//		final Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
//		return expiration.before(new Date());
//	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}