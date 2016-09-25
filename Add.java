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
public class Add extends BinaryOperator {
    
    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final Add INSTANCE = new Add();
    }
    
    /**
     * Creates a singleton pattern for the Add operation
     * @return an Add operation
     */
    public static final Add singleton() { return HOLDER.INSTANCE; }

    /**
     * Implement the binary operation add
     */
    private Add() {
        super("+");
    } 

    @Override
    public String calculate(String lho, String rho) {
        // TODO catch error state 
        return String.valueOf(Double.valueOf(lho) + Double.valueOf(rho));
    }
    
    
}
