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
public class EulerNumber extends Constant{

    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final EulerNumber INSTANCE = new EulerNumber();
    }
    
    /**
     * Creates an instance of the Eulernumber (e)
     * @return the e constant
     */
    public static final EulerNumber singleton() { return HOLDER.INSTANCE; }
    
    /** 
     * Implements the e operator
     */
    public EulerNumber() {
        super("e");
    }
    
    /**
     * The value of the EulerNumber constant
     * @return the value of the EulerNumber constant
     */
    @Override
    public String getValue(){
        return "2.71828182845904523536028747135266249775724709369995";
    }
}
