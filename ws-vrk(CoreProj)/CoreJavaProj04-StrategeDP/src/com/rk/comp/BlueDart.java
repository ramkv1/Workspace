package com.rk.comp;

public final class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		
		return oid+" order item are kept for delivery by BlueDart";
	}

}
