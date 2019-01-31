/*
 * Copyright � 2011 Posidex Technologies Pvt Ltd. All rights reserved.
 * Class: com.posidex.ws.exception.PosidexException.java
 * Created On: Jun 08, 2011 14:00:00 PM
 * Modified on: Nov 19, 2011 6:25:39 PM
 * 
 */

package com.posidex.prime.exception;

/**
 * The Class PosidexException.
 * 
 * @author <a href="mailto:kannaiah.uppula@posidex.com">Kannaiah Uppula</a>
 * @version $Revision: 1.2 $
 */
public class PosidexException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5657188683326586153L;

	/**
	 * Instantiates a new posidex exception.
	 */
	public PosidexException() {
		super();
	}

	/**
	 * Instantiates a new posidex exception.
	 * 
	 * @param errorMsg
	 *            the error msg
	 */
	public PosidexException(String errorMsg) {
		super(errorMsg);
	}

	/**
	 * Instantiates a new posidex exception.
	 * 
	 * @param t
	 *            the t
	 */
	public PosidexException(Throwable t) {
		super(t);
	}

}
