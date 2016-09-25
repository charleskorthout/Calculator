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
public abstract class BinaryOperator extends Operator implements ICalculate{
    
    private String lho;
    private String rho;
    

    /**
     * Implement a binary operation
     * @param name the name (or symbol) of the operation
     */
    protected BinaryOperator(String name) {
        super(name,OperatorType.Binary);
    }   
    
    /**
     * Sets the left hand operand
     * @param lho first operand value
     */
    public void setLeftOperand(String lho) {
        this.lho = lho;
    }
    
    /**
     * Get the first operand value
     * @return the first operand value
     */
    public String getLeftOperand() {
        return this.lho;
    }
    
    /**
     * sets the value for the second operand
     * @param rho the right hand operand value
     */
    public void setRightOperand(String rho) {
        this.rho = rho;
    }
    
    /**
     * Get the value of the second operand
     * @return the right hand operand value
     */
    public String getRightOperand(){
        return rho;
    }
    
    /**
     * All derived classes must implement this method
     * @param lho left hand operand
     * @param rho right hand operand
     * @return the result of the calculation
     */
    protected abstract String calculate(String lho, String rho); 
    
    /**
     * Returns the result of the calculation
     * @return the value of the computation
     */
    @Override
    public String calculate() {
        return this.calculate(lho,rho);
    };       
}
