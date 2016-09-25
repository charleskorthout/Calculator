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
public class Divide extends BinaryOperator {

    
    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Divide INSTANCE = new Divide();
    }
    
    /**
     * Creates a Divide operation
     * @return the Divide operation
     */
    public static final Divide singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the divide operation
     */
    private Divide() {
        super("/");
    }
    
    @Override
    public String calculate(String lho, String rho) {
        // TODO catch error state 
        return String.valueOf(Double.valueOf(lho) / Double.valueOf(rho));
    }
    
}
