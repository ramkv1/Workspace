package com.rk.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public final class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		
		return oid+" Order items are kept for delivery by DTDC" ;
	}

}
