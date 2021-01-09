/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author faiya
 */
public class AcquaintanceVendor {

    private ArrayList<ArrayList<Acquaintances>> a;
    private boolean flag;
    private boolean dflag;
    int index;
    int tindex;
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

    public AcquaintanceVendor(MUI mg, int index, int tindex) {
        this.mg = mg;
        this.index = index;
        this.tindex = tindex;
        this.flag = mg.getFlag();
        this.dflag = mg.getDflag();
        this.a = mg.getA();
        this.jPanel1 = mg.getjPanel1();
        this.jPanel3 = mg.getjPanel3();

    }

    public void add() {

        jPanel1.setVisible(false);
        mg.setjPanel1(jPanel1);
        jPanel3.setVisible(true);
        mg.setjPanel3(jPanel3);
        mg.setX(index);
        flag = true;
        mg.setFlag(flag);
        dflag = false;
        mg.setDflag(dflag);
        mg.setDescription();
    }

    public void delete() {
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        if (tindex < 0) {
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        int n = JOptionPane.showConfirmDialog(
                mg,
                "Are you sure you want to delete this?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            a.get(index).remove(tindex);
            mg.setA(a);
            JOptionPane.showMessageDialog(mg, "Successfully Deleted");
            mg.setUpTableData();
        }
    }
}
