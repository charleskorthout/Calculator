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
public abstract class UnaryOperator extends Operator implements ICalculate{
    
    private String operand;
    
    /**
     * Implement a binary operation
     * @param name the name or symbol of the operator
     */
    protected UnaryOperator(String name) {
        super(name,OperatorType.Unary);
    }   
    
    /**
     * Sets the operand of the operation
     * @param lho the operand
     */
    public void setLeftOperand(String lho) {
        this.operand = lho;
    }
    
    /**
     * Gets the value of the operand
     * @return the value of the operand
     */
    public String getLeftOperand() {
        return this.operand;
    }
    
        
    /**
     * All derived classes must implement this method
     * @param operand left hand operand
     * @return the result of the calculation
     */
    protected abstract String calculate(String operand); 
    
    /**
     * Returns the result of the calculation
     * @return the result of the calculation
     */
    @Override
    public String calculate() {
        return this.calculate(operand);
    };       
}