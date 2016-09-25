/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 * Backspace 
 */
public class Backspace extends Operator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Backspace INSTANCE = new Backspace();
    }
    
    /**
     * Creates a singleton pattern for the Backspace operation
     * @return an Backspace operation
     */
    public static final Backspace singleton() { return HOLDER.INSTANCE; }

    /**
     * implement the backspace operation
     */
    private Backspace() {
        super("⌫", OperatorType.Backspace);
    }
}

