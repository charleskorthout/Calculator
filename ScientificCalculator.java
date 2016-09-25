/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import java.util.HashMap;

/**
 *
 * @author Charles Korthout
 */
public class ScientificCalculator {
    private String lho = "0"; // The left operand of a binary or unary operation ("34" above).
    private boolean lho_decimalPoint = false; // has a decimal point been added to the left operand
    private String rho; // The right operand of a binary operation ("56" above).
    private boolean rho_decimalPoint = false; // has a decimal point been added to the right operand
    private Operator currentOperator = NoOperation.singleton(); // The binary operator ("+" above) which is to be applied to these operands.
    private String display = "0"; // The current contents of the display unit.
    private CalculatorContext context; //Indicates the context in which the calculator is currently running (see below).
    private final HashMap<String,IOperator> operators; // A list of the operators and their respective types for the current calculator.
    
    private static class Holder {
        static final ScientificCalculator INSTANCE = new ScientificCalculator();
    }

    static final ScientificCalculator singleton() { return Holder.INSTANCE;}
    /**
     * Defines the calculator state to be ready to process selections. 
     * The display unit is initialized with the value of 0.
     */
    private ScientificCalculator() {
        context = CalculatorContext.RLHO;
        operators = new HashMap();
        // binary operators
        operators.put(Add.singleton().getName(), Add.singleton());
        operators.put(Subtract.singleton().getName(),Subtract.singleton());
        operators.put(Divide.singleton().getName(),Divide.singleton());
        operators.put(Multiply.singleton().getName(),Multiply.singleton());
        // unary operators
        operators.put(Negate.singleton().getName(),Negate.singleton());
        // some constants
        operators.put(PI.singleton().getName(), PI.singleton());
        operators.put(EulerNumber.singleton().getName(), EulerNumber.singleton());
        // Generic operators
        operators.put(Clear.singleton().getName(), Clear.singleton());
        operators.put(ClearLastOperand.singleton().getName(), ClearLastOperand.singleton());
        operators.put(Assignment.singleton().getName(), Assignment.singleton());
        operators.put(Backspace.singleton().getName(), Backspace.singleton());
        // Fallback
        operators.put(NoOperation.singleton().getName(), NoOperation.singleton());
    }
    
    /**
     * This method implements the action(s) that take place whenever a calculator button has been clicked. 
     * For example, to add the numbers 42 and 5 the user click the sequence of buttons: "4", "2", "+","5", and "=". 
     * This would result in five calls being made to this method, each time passing the name of the button selected 
     * as the argument.
     * @param selection The button selected
     */
    
    public void processSelection(String selection) {
        IOperator operator = NoOperation.singleton();
        if (operators.containsKey(selection)){
            operator = operators.get(selection);
        }
        // Handle generic operations
        switch(operator.getClass().getCanonicalName()){
            case "calculator.Clear" : 
                clear();
                break;
            case "calculator.ClearLastOperand" : 
                if (context == CalculatorContext.RRHO) {
                    clearLastOperand();
                }
                break;
            case "calculator.Backspace" :
                if (context == CalculatorContext.RLHO) {
                    if (!lho.equals("0")) lho = lho.substring(lho.length() - 1);                    
                }
                else if (context == CalculatorContext.RRHO) {
                    if (!rho.equals("0")) rho = rho.substring(rho.length() - 1);                    
                }
                break;
            case "calculator.Assignment" :
                if (context == CalculatorContext.RRHO)  {
                    try {
                        display = processBinaryOperator(lho, currentOperator, rho);
                    }
                    catch (IllegalOperatorException ioe) {
                        context = CalculatorContext.Error;
                        display = "Error";
                    }
                }
                else if (context == CalculatorContext.RLHO) {
                    // copying the Microsoft Calculator algorithm
                    if (!(currentOperator instanceof NoOperation)){
                        String result;
                        if (currentOperator instanceof Add){
                            result = Add.singleton().calculate(lho, lho);
                            lho = result;
                            display = result;
                            // TODO handle decimal point
                        }
                        if (currentOperator instanceof Subtract){
                            result = Subtract.singleton().calculate(lho, lho);
                            lho = result;
                            display = result;
                            // TODO handle decimal point
                        }
                        if (currentOperator instanceof Multiply){
                            result = Multiply.singleton().calculate(lho, lho);
                            lho = result;
                            display = result;
                            // TODO handle decimal point
                        }
                        if (currentOperator instanceof Divide){
                            result = Divide.singleton().calculate(lho, lho);
                            lho = result;
                            display = result;
                            // TODO handle decimal point
                            // TODO handle divide by 0
                        }
                    }    
                }
                break;
            // Binary operations
            case "calculator.Add":
            case "calculator.Subtract":
            case "calculator.Divide":
            case "calculator.Multiply" : 
                if (context == CalculatorContext.RLHO) {
                    context = CalculatorContext.RRHO;
                    currentOperator = (BinaryOperator)operator;
                    rho = "0";
                    display = "0";
                }
                else if (context == CalculatorContext.RRHO) {
                    // we must first calculate the binary operation and provide this to the left hand operand
                    BinaryOperator current = (BinaryOperator)currentOperator;
                    current.setLeftOperand(lho);
                    current.setRightOperand(rho);
                    lho = current.calculate();
                    display = lho;
                    currentOperator = (BinaryOperator)operator;
                    rho = "0";
                    // TODO handle decimal point
                }
                break;
            // handle constants    
            case "calculator.PI" :
            case "calculator.EulerNumber" :    
                if (context == CalculatorContext.RLHO) {
                    String result = ((Constant)operator).calculate();
                    lho = result;
                    display = result;
                    // TODO handle decimal point
                }
                else if (context == CalculatorContext.RRHO) {
                    String result = ((Constant)operator).calculate();
                    rho = result;
                    display = result;
                    // TODO handle decimal point
                }
                break;
            // handle unary operations
            case "calculator.Negate" :
                if (context == CalculatorContext.RLHO) {
                    String result = ((Negate)operator).calculate();
                    lho = result;
                    display = result;
                    // TODO handle decimal point
                }
                else if (context == CalculatorContext.RRHO) {
                    String result = ((Negate)operator).calculate();
                    rho = result;
                    display = result;
                    // TODO handle decimal point
                }
                break;
            // checking for digits etc
            default : 
                if (isDigit(selection)) {
                    if (context == CalculatorContext.RLHO) {
                        if (lho.equals("0")) lho = selection;
                        else lho = lho + selection;                       
                        display = lho;
                    }
                    if (context == CalculatorContext.RRHO) {
                        if (rho.equals("0")) rho = selection;
                        else rho = rho + selection;
                        display = rho;
                    }
                }
                if (isDecimalPoint(selection)) {
                    if ((context == CalculatorContext.RLHO) && !lho_decimalPoint) {
                        lho = lho + selection;
                        lho_decimalPoint = true;
                        display = lho;
                    }
                    if ((context == CalculatorContext.RRHO) && !rho_decimalPoint){
                        rho = rho + selection;
                        rho_decimalPoint = true;
                        display=rho;
                    }
                }
                
        }        
    }
            

    /**
     * As the calculator is used, your program must keep track of the quantity to be shown in the calculators display unit. 
     * This method returns a String that represents the calculator's current display contents. 
     * It is called by the GUI whenever the display needs to be updated.
     * @return the result to display
     */
    public String getDisplayContents(){
        return display;
    }
    
    /**
     * This method is called by processSelection once a unary operator and its operand have been identified. 
     * The processUnaryOperator method must implement the functionality of all the unary operators.
     * 
     * This method is called by processSelection once a unary operator and its operand have been identified. 
     * The processUnaryOperator method must implement the functionality of all the unary operators provided.
     * 
     * Note that the argument is passed in as a String (not double or integer). 
     * Rather than converting digits to numbers immediately as each digit button is pressed, it is easier 
     * to concatenate the digits into a string, then pass the string to processUnaryOperator (or processBinaryOperator below), 
     * and then convert the result to a number. You may assume the operator input is valid.
     * @param operand The operand
     * @param operator The unary operator
     * @return the result of the operation
     * @throws IllegalOperatorException an exception is thrown if this function is called with a non unary function. Must not happen as this can be handled
     * by the processSelection method
     */
    public String processUnaryOperator(String operand, IOperator operator) throws IllegalOperatorException {
        if (operator instanceof UnaryOperator) {
            UnaryOperator uo = ((UnaryOperator)operator);
            uo.setLeftOperand(operand);
            return uo.calculate();
        }
        else throw new IllegalOperatorException(); // TODO a bit more error explanation please
    }
    
    /**
     * This is a method similar to processUnaryOperator that deals with binary operators.
     * @param lho The left hand or first operand
     * @param operator the binary operator
     * @param rho the right hand or second operand
     * @return the result of the calculation
     * @throws IllegalOperatorException an exception is thrown if this function is called with a non binary function. Must not happen as this can be handled
     * by the processSelection method
     */
    public String processBinaryOperator(String lho, IOperator operator, String rho) throws IllegalOperatorException {
        if (operator instanceof BinaryOperator) {
            BinaryOperator bo = ((BinaryOperator)operator);
            bo.setLeftOperand(lho);
            bo.setRightOperand(rho);
            return bo.calculate();
        }
        else throw new IllegalOperatorException(); // TODO a bit more error explanation please
    }
    
    /**
     * This method is called by processSelection once a constant operator has been identified. 
     * The processConstantOperator method returns a String representing the constant value associated 
     * with the operator parameter
     * @param operator The constant operator
     * @return the value of the constant
     * @throws IllegalOperatorException an exception is thrown if this function is called with a non constant function. Must not happen as this can be handled
     * by the processSelection method
     */
    public String processConstantOperator(IOperator operator) throws IllegalOperatorException {
        if (operator instanceof Constant) {
            Constant bo = ((Constant)operator);
            return bo.calculate();
        }
        else throw new IllegalOperatorException(); // TODO a bit more error explanation please
    }
    
    /**
     * Helper function to determine if a digit key is pressed
     * @param s the string to check
     * @return the logical value if this string is a valid digit (0..9)
     */
    private boolean isDigit(String s) {
        if (s.length() != 1) return false;
        else {
            char c = s.charAt(0);
            return Character.isDigit(c);
        }                
    }
    
    /**
     * Helper function to determine if a decimal point key is pressed
     * @param s the string to check
     * @return the logical value if this string is decimal point '.'
     */
    private boolean isDecimalPoint(String s) {
        if (s.length() != 1) return false;
        else return s.equals(".");
    }
    
    /**
     * Helper function to clear all settings
     */
    private void clear() {
        context = CalculatorContext.RLHO;
        display = "0";
        lho = "0";
        lho_decimalPoint = false;
        currentOperator = NoOperation.singleton();
    }
    
    /**
     * helper function to clear second operand settings
     */
    private void clearLastOperand(){
        display = "0";
        rho = "0";
        rho_decimalPoint = false;
    }
}
