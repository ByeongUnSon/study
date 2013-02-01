
package com.lcson.codemodel.gen;


public abstract class AbstractClass {

    private int code;
    
    private int value;
    
    public AbstractClass() { }
    
    public AbstractClass(int value) {
    	this.value = value;
    }
    
    public void start() {
    	int v = value;
    	process(v);
    }
      
    public void setCode(int code) {
    	this.code = code;
    }
    
    public int getCode() {
    	return code;
    }
    
    public abstract void process(int input);
    
   

}
