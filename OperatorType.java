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
public enum OperatorType { 
    /**
     * The no operation operator. Is initial operator for binary operation or fallback
     */
    NoOp, 
    /**
     * The unary operator type, takes a single operand
     */
    Unary, 
    /**
     * The binary operator, takes two parameters
     */
    Binary, 
    /**
     * The assignment operator
     */
    Assignment, 
    /**
     * The clear operator sets the calculator to the default (start) state
     */
    Clear, 
    /**
     * The clear last operand operator clears the second operand in a binary operation
     */    
    ClearLastOperand, 
    /**
     * The backspace operator removes the last character of an operand based on the context
     */
    Backspace, 
    /**
    * The constant operator returns a constant value
    */
    Constant }