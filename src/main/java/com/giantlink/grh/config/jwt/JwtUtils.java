package com.giantlink.grh.config.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.giantlink.grh.services.impl.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	@Value("${grh.app.jwtSecret}")
	private String jwtSecret;

	@Value("${grh.app.jwtExpiration}")
	private Integer jwtExpiration;

	public String generateToken(Authentication authentication) {
		UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder().setSubject(principal.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Jws<Claims> valideToken(String jwt) {
		try {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
		} catch (SignatureException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (MalformedJwtException e) {
			System.out.println(e.getMessage());
		} catch (ExpiredJwtException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (UnsupportedJwtException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String getUsernameFromToken(String jwt) {
		return valideToken(jwt).getBody().getSubject();
	}

}
