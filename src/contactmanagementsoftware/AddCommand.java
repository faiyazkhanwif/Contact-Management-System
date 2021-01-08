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
public class AddCommand implements Command {

    Acquaintances acq;

    public AddCommand(Acquaintances acq) {
        this.acq = acq;
    }

    @Override
    public void execute() {
    }

}
