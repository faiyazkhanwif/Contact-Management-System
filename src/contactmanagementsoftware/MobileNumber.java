/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

//Used for Strategy Pattern
/**
 *
 * @author faiya
 */
public class MobileNumber extends InformationToBeVerified{

    public MobileNumber(MUI mui,String number) {
        super(mui,number);
        valbehavior = new ValidationOfNumber(mui,number);
    }
}
