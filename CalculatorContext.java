/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Charles Korthout
 The calculator's operation depends on the context. The possible contexts (states) are:
 Reading-Left-Hand-Operand (RLHO): This is the default context. Any digits that are entered are stored in the first operand.
 Reading-Second-Hand-Operand (RRHO): This context is entered whenever a binary operator is entered. 
  Digits that are entered are stored in the second operand.
 Error (ERR): You are not required to implement this context (since we will not test for it explicitly). 
 This context is entered whenever an error occurs (e.g., invalid input such as "3.4.5" or division by zero). 
 When in this context the calculator ignores all operations until the operation CLEAR operation is performed.
 */
public enum CalculatorContext { 
    /**
     * Currently Reading the first operand (left hand operand)
     */
    RLHO, 
    /**
     * Currently reading the second operand (right hand operand)
     */
    RRHO, 
    /**
     * An error has occurred, need clearing first
     */
    Error }