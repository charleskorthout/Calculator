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
public class NoOperation extends Operator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final NoOperation INSTANCE = new NoOperation();
    }
    
    /**
     * Return an instance of the NoOperation operation
     * @return 
     */
    public static final NoOperation singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the nill operation, ignores the operation. Fallback for not yet implemented
     * operations .
     */
    private NoOperation() {
        super("###", OperatorType.NoOp);
    }
}