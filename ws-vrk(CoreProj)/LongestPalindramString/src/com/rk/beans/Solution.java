package com.rk.beans;

import java.math.BigInteger;

class Solution {
	public static void main(String[] args) {
		Solution solution=new Solution();
		System.out.println(solution.addBinary("11", "1"));
	}
	
	
    public String addBinary(String a, String b) {
    return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
