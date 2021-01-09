/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author faiya
 */
public class ValidationOfDate implements ValidationBehavior {

    String date;
    MUI mui;

    public ValidationOfDate(MUI mui, String date) {
        this.mui = mui;
        this.date = date;
    }

    @Override
    public boolean validate() {
        String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (!m.find()) {
            JOptionPane.showMessageDialog(mui, "Enter a valid date");
            return false;
        } else {
            return true;
        }
    }

}
