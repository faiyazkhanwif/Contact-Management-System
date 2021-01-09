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
public abstract class InformationToBeVerified {
    String information;
    ValidationBehavior valbehavior;
    MUI mui;

    public InformationToBeVerified(MUI mui,String information) {
        this.mui = mui;
        this.information = information;
    }

    public boolean performValidation() {
        return valbehavior.validate();
    }

    public void setValBehavior(ValidationBehavior vb) {
        valbehavior = vb;
    }
}
