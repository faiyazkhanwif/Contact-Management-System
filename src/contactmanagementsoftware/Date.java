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
public class Date extends InformationToBeVerified{
    
    public Date(MUI mui, String date) {
        super(mui,date);
        valbehavior = new ValidationOfDate(mui,date);
    }
    
}
