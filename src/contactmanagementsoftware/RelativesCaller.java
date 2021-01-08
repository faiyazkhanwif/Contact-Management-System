/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

/**
 *
 * @author faiya
 */
public class RelativesCaller extends AcquaintanceFactory{

    @Override
    public Acquaintances getAcquaintance(String acquaintanceType) {
        if (acquaintanceType == "Relatives") {
            return new Relatives();
        } else {
            return null;
        }
    }
}
