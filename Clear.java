/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 * Clear implements the initial state
 */
public class Clear extends Operator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Clear INSTANCE = new Clear();
    }
    
    /**
     * returns the singleton of the clear operation
     * @return a Clear operation
     */
    public static final Clear singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the clear operation
     */
    private Clear() {
        super("C", OperatorType.Clear);
    }
}

