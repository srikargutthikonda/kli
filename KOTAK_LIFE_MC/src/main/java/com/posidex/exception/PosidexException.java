package com.posidex.exception;

public class PosidexException extends Exception{
	  private static final long serialVersionUID = 8502813626281421768L;

	  /**
	     * Default constructor, does nothing.
	     */
	    public PosidexException()
	    {
	      super();
	    }

	    /**
	     * @param msg The message of the exception. 
	     */
	    public PosidexException(String msg)
	    {
	      super(msg);
	    }

}
