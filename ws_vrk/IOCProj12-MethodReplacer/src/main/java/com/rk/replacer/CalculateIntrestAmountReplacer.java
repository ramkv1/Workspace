package com.rk.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("ciaReplacer")
public class CalculateIntrestAmountReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("CalculateIntrestAmountReplacer.reimplement(-,-,-)(Simple IntrestAmount)");
		//get target b.method arg Values
		double pamt=(double) args[0];
		double time=(double) args[1];
		double rate=(double) args[2];
		return pamt*rate*time/100.0f;
	}

}
