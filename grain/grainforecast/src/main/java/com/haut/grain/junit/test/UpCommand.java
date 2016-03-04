package com.haut.grain.junit.test;

public class UpCommand extends Command{

@Override
public void execute() {
	System.out.println("向上命令的状态是:"+this.getState());
}

}
