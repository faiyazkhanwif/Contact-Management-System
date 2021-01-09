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
public class ValidationOfNumber implements ValidationBehavior {
    String number;
    MUI mui;

    public ValidationOfNumber(MUI mui,String number) {
        this.mui = mui;
        this.number = number;
    }

    @Override
    public boolean validate() {
        int x;
        if (number.isEmpty() || number.length() < 6 || number.length() > 15) {
            return false;
        }
        for (int j = 0; j < number.length(); j++) {
            x = (int) number.charAt(j);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }

}
