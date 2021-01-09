/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;


//Used for Command Pattern
/**
 *
 * @author faiya
 */
public class AddCommand implements Command {

    AcquaintanceVendor acqs;

    public AddCommand(AcquaintanceVendor acqs) {
        this.acqs = acqs;
    }

    @Override
    public void execute() {
        acqs.add();
    }

}
