/**
 * 
 */
package com.xunfeng.business.jobfair.exception;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class BoothOccupiedException extends Exception implements Serializable {
	
	
  public BoothOccupiedException(){
	  super() ;
  }
  public BoothOccupiedException(String message){
	  super(message);
  }
//  public BoothOccupiedException(Throwable cause){
//	  super(cause);
//  }
//  public BoothOccupiedException(String message, Throwable cause) {
//		// TODO
//		super(message, cause);
//	}
  
}
