package com.haut.grain.junit.test;

public abstract class CommandManager {

    public void process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}