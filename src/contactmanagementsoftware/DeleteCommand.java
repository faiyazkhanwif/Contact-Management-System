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
public class DeleteCommand implements Command {

    Acquaintances acq;

    public DeleteCommand(Acquaintances acq) {
        this.acq = acq;
    }

    @Override
    public void execute() {

    }

}
