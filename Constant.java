/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

/**
 *
 * @author Charles Korthout
 * Constant operation
 */
public abstract class Constant extends Operator implements ICalculate {
    
    /**
     * constructor
     * @param name the name of symbol of the constant
     */
    protected Constant(String name) {
        super(name, OperatorType.Constant);
    } 
    
    /**
     * The constant value
     * @return the value of the constant
     */
    protected abstract String getValue();   
    
    @Override
    public String calculate() {
        return getValue();
    }
    
}

