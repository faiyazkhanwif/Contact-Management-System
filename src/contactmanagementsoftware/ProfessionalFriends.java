package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;


//Used for Factory method pattern.
/**
 *
 * @author faiya
 */
public class ProfessionalFriends extends Acquaintances implements Serializable {

    private String CommonInterests;
    public static int numberProF = 0;

    ProfessionalFriends() {
        numberProF++;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String Name) {
        super.setName(Name);
    }

    @Override
    public String getMobileNo() {
        return super.getMobileNo();
    }

    @Override
    public void setMobileNo(String MobileNo) {
        super.setMobileNo(MobileNo);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String Email) {
        super.setEmail(Email);
    }

    public String getCommonInterests() {
        return CommonInterests;
    }

    public void setCommonInterests(String CommonInterests) {
        Scanner reader = new Scanner(System.in);
        if (!CommonInterests.isEmpty()) {
            this.CommonInterests = CommonInterests;
        } else {
            System.out.println("Enter at least one character");
            setCommonInterests(reader.nextLine());
        }
    }

    @Override
    public void setFirstExclusiveInformation(String CommonInterests) {
        setCommonInterests(CommonInterests);
    }

    @Override
    public void setSecondExclusiveInformation(String information) {
    }

    @Override
    public void setThirdExclusiveInformation(String information) {
    }
}
