/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 * Assignment operator
 */
public class Assignment extends Operator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Assignment INSTANCE = new Assignment();
    }
    
    /**
     * Creates a singleton pattern for the Assignment operation
     * @return an Assignment operation
     */
    public static final Assignment singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement an assignment operation
     */
    private Assignment() {
        super("=", OperatorType.Assignment);
    }    
}

