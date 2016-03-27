package org.rooinaction.coursemanager.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void beforeCall() {
		System.out.println("... before call ...");
	}

	public void afterCall() {
		System.out.println("... after call ...");
	}
	
	public void afterReturnCall() {
		System.out.println("... after return call ...");
	}

	public void afterThrowingCall() {
		System.out.println("... after throwing call ...");
	}
	
	public Object aroundCall(ProceedingJoinPoint jp) throws Throwable {
		try {
			System.out.println("... around before call ...");
			Object returnValue = jp.proceed();
			System.out.println("... around after call ...");
			return(returnValue);
		} catch (Throwable t) {
			System.out.println("... exception around call ..." + t.getMessage());
			throw(t);
		}
	}
	
	/*
	 * aspectJ with parameter
	 */
	public void beforeCallWithParameters(String locationName) {
		System.out.println("... before call ... p = " + locationName);
	}

	public void afterCallWithParameters(String locationName) {
		System.out.println("... after call ... p = " + locationName);
	}
	
	public void afterReturnCallWithParameters(String locationName) {
		System.out.println("... after return call ... p = " + locationName);
	}

	public void afterThrowingCallWithParameters(String locationName) {
		System.out.println("... after throwing call ... p = " + locationName);
	}
	
	public Object aroundCallWithParameters(ProceedingJoinPoint jp, String locationName) throws Throwable {
		try {
			System.out.println("... around before call ... p = " + locationName);
			Object returnValue = jp.proceed(new Object[]{locationName});
			System.out.println("... around after call ... p = " + locationName);
			return(returnValue);
		} catch (Throwable t) {
			System.out.println("... exception around call ..." + t.getMessage());
			throw(t);
		}
	}
	
//	public void beforeCallWithParameters(String locationName) {
//		System.out.println("... before call ..., parmeters = " + locationName);
//	}
//
//	public void aroundCall(ProceedingJoinPoint jointpoint) {
//		try {
//			System.out.println("... around before call ...");
//			jointpoint.proceed();
//			System.out.println("... around after call ...");
//		} catch (Throwable t) {
//			System.out.println("... exception around call ..." + t.getMessage());
//		}
//	}
}
