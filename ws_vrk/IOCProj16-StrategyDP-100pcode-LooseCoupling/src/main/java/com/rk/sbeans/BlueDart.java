package com.rk.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public final class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		
		return oid+" Order items are kept for delivery by BlueDartC" ;
	}

}
