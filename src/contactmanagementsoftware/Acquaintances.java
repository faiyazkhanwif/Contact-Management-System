package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

//Used for Template method pattern.
//Used for Factory method pattern.
/**
 *
 * @author faiya
 */
public abstract class Acquaintances implements Serializable {

    private String Name;
    private String MobileNo;
    private String Email;
    public static int number = 0;

    Acquaintances() {
        number++;
    }
    //-------------------------------------------------Template method pattern---------------------------------------------------------------
    final void createAcquaintances(String name, String MobileNo, String Email, String informationOne,
        String informationTwo, String informationThree) {
        setName(name);
        setMobileNo(MobileNo);
        setEmail(Email);
        setFirstExclusiveInformation(informationOne);
        setSecondExclusiveInformation(informationTwo);
        setThirdExclusiveInformation(informationThree);
    }

    public abstract void setFirstExclusiveInformation(String informationOne);
    public abstract void setSecondExclusiveInformation(String informationOne);
    public abstract void setThirdExclusiveInformation(String informationOne);

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Scanner reader = new Scanner(System.in);
        if (!name.isEmpty()) {
            this.Name = name;
        } else {
            System.out.println("Enter atleast one character");
            setName(reader.nextLine());
        }
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public boolean MobileNoChecker(String str) {
        int x;
        for (int j = 0; j < str.length(); j++) {
            x = (int) str.charAt(j);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }

    public void setMobileNo(String MobileNo) {
        Scanner reader = new Scanner(System.in);
        if (MobileNoChecker(MobileNo) && MobileNo.length() >= 6 && MobileNo.length() <= 15) {
            this.MobileNo = MobileNo;
        } else {
            System.out.print("Enter a valid Mobile No of length between 6 and 15 (inclusive): ");
            setMobileNo(reader.next());
        }
    }

    public void setEmail(String Email) {
        Scanner reader = new Scanner(System.in);
        if (Email.contains("@")) {
            this.Email = Email;
        } else {
            System.out.print("Enter a valid Email: ");
            this.setEmail(reader.next());
        }
    }
}
