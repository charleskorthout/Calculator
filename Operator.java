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
public abstract class Operator implements IOperator{
    
    private final String oname;
    private final OperatorType otype;
    
    /**
     * Default constructor
     * @param name the name of symbol of the operator
     * @param operatorType the type of the operator @see OperatorType
     */
    protected Operator(String name, OperatorType operatorType) {
        oname = name;
        otype = operatorType;
    }
    
    /**
     * Get the operator type (binary, unary, constant etc)
     * @return the operator type
     */
    @Override
    public OperatorType getType() {
        return otype;
    }

    /**
     * Get the name / symbol of the operator
     * @return the operator name
     */
    @Override
    public String getName() {
        return oname;
    }
    
}
