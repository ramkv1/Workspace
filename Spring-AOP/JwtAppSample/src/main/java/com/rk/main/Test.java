package com.rk.main;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
class Test 
{
    public static void main( String[] args )
    {
    	String key="NIT";
    	//Token Generation 
    	String token=
    	Jwts.builder()
    	.setId("A5266")
    	.setSubject("AJAY")
    	.setIssuer("NareshIT")
    	.setIssuedAt(new Date(System.currentTimeMillis()))
    	.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
    	.signWith(SignatureAlgorithm.HS256, //sign alog
    			Base64.getEncoder().encode(key.getBytes())) //secrekey
    	.compact(); //String
    	System.out.println(token);
    	//---------Reading token/parsing token
    	Claims c=
    	Jwts.parser()
    	.setSigningKey(Base64.getEncoder().encode(key.getBytes())) //secrekey
    	.parseClaimsJws(token)
    	.getBody();
    	
    	System.out.println(c.getSubject());
    	System.out.println(c.getId());
    	System.out.println(c.getIssuer());
    	System.out.println(c.getExpiration());
    }
}
