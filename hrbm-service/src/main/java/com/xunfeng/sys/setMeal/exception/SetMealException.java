/**
 * 
 */
package com.xunfeng.sys.setMeal.exception;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class SetMealException extends Exception implements Serializable {
	
	
  public SetMealException(){
	  super() ;
  }
  public SetMealException(String message){
	  super(message);
  }
  
}
