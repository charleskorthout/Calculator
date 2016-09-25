/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 */
public class Negate extends UnaryOperator {
    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Negate INSTANCE = new Negate();
    }
    
    /**
     * Returns an instance of the Negate operator
     * @return an instance of the Negate operator
     */
    public static final Negate singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the negate operation
     */
    private Negate() {
        super("±");
    }
    
    /**
     * Negates the value of the operand
     * @param operand
     * @return the negation of the value
     */
    @Override
    public String calculate(String operand) {
        //TODO catch errors
        return String.valueOf(-1.0 * Double.valueOf(super.getLeftOperand()));
    }
}
