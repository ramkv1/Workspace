//Utility class
package com.rk.main;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	//1.Generate token
	public String generateToken(String id,String subject,String key)
	{
		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("NareshIT")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(5)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
				.compact();
	
	}
	//get claims
	public Claims getClaims(String key,String token) {
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}
	
	/*  public String getSubject(String key,String token) { return getClaims(key,
	  token).getSubject(); } public Boolean isValidToken(String key,String token) {
	  expiration date>current Date return getClaims(key, token) .getExpiration()
	  .after(new Date(System.currentTimeMillis())); }
	 */
	
	}
