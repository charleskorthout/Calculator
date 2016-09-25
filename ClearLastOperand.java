/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 * Clears the last operand
 */
public class ClearLastOperand extends Operator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final ClearLastOperand INSTANCE = new ClearLastOperand();
    }
    
    /**
     * The singleton 
     * @return an instance of the ClearLastOperand operation
     */
    public static final ClearLastOperand singleton() { return HOLDER.INSTANCE; }

    /**
     * Implements the clear last operand
     */
    private ClearLastOperand() {
        super("CE", OperatorType.ClearLastOperand);
    }
       
}

