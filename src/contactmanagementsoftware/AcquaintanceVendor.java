/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author faiya
 */
public class AcquaintanceVendor {

    private boolean flag;
    private boolean dflag;
    int index;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    MUI mg;

    public AcquaintanceVendor(MUI mg, int index) {
        this.mg = mg;
        this.index = index;
        this.flag = mg.getFlag();
        this.dflag = mg.getDflag();

        this.jPanel1 = mg.getjPanel1();
        this.jPanel3 = mg.getjPanel3();

    }
    
    public void add(){
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        jPanel1.setVisible(false);
        mg.setjPanel1(jPanel1);
        jPanel3.setVisible(true);
        mg.setjPanel3(jPanel3);
        
        mg.setX(index);
        flag = true;
        mg.setFlag(flag);
        dflag = false;
        mg.setDflag(dflag);
    }
    
    public void delete(){
        
    }
}
