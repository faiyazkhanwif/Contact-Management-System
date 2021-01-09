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
public class FriendsCaller extends AcquaintanceFactory {

    @Override
    public Acquaintances getAcquaintance(String acquaintanceType) {
        if (acquaintanceType == "ProfessionalFriends") {
            return new ProfessionalFriends();
        } else if (acquaintanceType == "PersonalFriends") {
            return new PersonalFriends();
        } else {
            return null;
        }
    }

}
