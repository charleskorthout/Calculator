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
public class PI extends Constant{
    
    /**
     * Reference to add operation for delegation purposes.
     */
    private static class HOLDER {
        static final PI INSTANCE = new PI();
    }
    
    /**
     * Returns an instance of the Pi constant
     * @return the pi constant
     */
    public static final PI singleton() { return HOLDER.INSTANCE; }
    
    /** 
     * Implements the PI operator
     */
    public PI() {
        super("PI");
    }
    
    /**
     * The PI value
     * @return the value of Pi
     */
    @Override
    public String getValue() {
        return "3,1415926535897932384626433832795";
    }

}
