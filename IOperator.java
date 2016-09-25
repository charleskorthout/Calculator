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
public interface IOperator {
    /**
     * Get the operator type of the operator
     * @return the operator type
     */
    OperatorType getType();
    
    /**
     * Get the name or symbol of the operator
     * @return the name of the operator
     */
    String getName();
}
