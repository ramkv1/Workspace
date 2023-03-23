package com.rk.main;

import io.jsonwebtoken.Claims;

public class Test1 {
	public static void main(String[] args) {
			JwtUtil util=new JwtUtil();
			String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBQTg4NSIsInN1YiI6IlJBR0hVIiwiaXNzIjoiTmFyZXNoSVQiLCJpYXQiOjE2NzczMTQ5MTksImV4cCI6MTY3NzMxNTIxOX0.DFfuz3hs0PvTTIKP4cq-Rr1jHoIl9xI1Jog0lTWhfoU";
			//Header.PlayLoad.Signature=JWTTOken
			//String token=util.generateToken("AA885", "RAGHU", "NITTEST");
			System.out.println(token);
			Claims c=util.getClaims("NITTEST", token);
			System.out.println(c.getId());
			System.out.println(c.getSubject());
			System.out.println(c.getExpiration());
	}
}
