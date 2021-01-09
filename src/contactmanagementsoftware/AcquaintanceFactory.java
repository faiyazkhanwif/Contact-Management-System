/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

//Used for Factory method pattern.
/**
 *
 * @author faiya
 */
public abstract class AcquaintanceFactory {

    public Acquaintances callAcquaintance(String acquaintanceType) {
        Acquaintances acquaintance;
        acquaintance = getAcquaintance(acquaintanceType);
        return acquaintance;
    }

//Factory Method
    public abstract Acquaintances getAcquaintance(String acquaintanceType);
}
