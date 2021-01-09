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
public class AddDeleteManager {

    Command slot;

    public AddDeleteManager() {

    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
