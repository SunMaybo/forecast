package com.haut.grain.junit.test;

public  class Command {
private Object state;
public void setState(Object state) {
	this.state = state;
}
public Object getState() {
	return this.state;
}
public  void execute(){
	System.out.println("当前的状态是:"+state.toString());
}
}
