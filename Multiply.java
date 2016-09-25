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
public class Multiply extends BinaryOperator {

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Multiply INSTANCE = new Multiply();
    }
    
    /**
     * Returns an instance of the multiply operator
     * @return the Multiply operator
     */
    public static final Multiply singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the multiply operator
     */
    private Multiply() {
        super("*");
    }
    
    @Override
    public String calculate(String lho, String rho) {
        // TODO catch error state 
        return String.valueOf(Double.valueOf(lho) * Double.valueOf(rho));
    }

}
