package com.park.einvoice.common.exception;

public final class ExceptionHandler{
	
	public static void castException(Throwable e){
		throw new RuntimeException(e);
	}
}