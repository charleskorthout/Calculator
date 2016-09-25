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
public class Subtract extends BinaryOperator{

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Subtract INSTANCE = new Subtract();
    }
    
    /**
     * Returns an instance of the binary subtract operator
     * @return an instance of the Subtract operator
     */
    public static final Subtract singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the subtract operator
     */
    private Subtract() {
        super("-");
    }
    
    @Override
    public String calculate(String lho, String rho) {
        // TODO catch error state 
        return String.valueOf(Double.valueOf(lho) - Double.valueOf(rho));
    }
}
