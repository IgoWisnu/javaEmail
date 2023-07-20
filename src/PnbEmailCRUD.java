import java.util.ArrayList;
import java.util.Scanner;

public class PnbEmailCRUD extends EmailCRUD{
    public ArrayList<PnbEmail> pnbEmail = new ArrayList<PnbEmail>();
    PnbEmail email = new PnbEmail();
    @Override
    public void addEmail(PnbEmail rawEmail) {
        this.pnbEmail.add(rawEmail);
    }

    @Override
    public void deleteEmail(int index) {
        this.pnbEmail.remove(index);
    }

    @Override
    public int editEmail(int index) {
        return 0;
    }
    @Override
    public void display() {
        int index =1;
        System.out.println("-----All Email-----");
        for (PnbEmail email : pnbEmail) {
            System.out.println(index+". "+email.getEmail()+" "+email.getPassword()+" "+email.getAccess()+" "+email.getCapacity());
            index++;
        }
        System.out.println("===========================================");
    }
    public boolean isEmailExist(int index){
        if(index <= pnbEmail.size()){
            return true;
        }
        return false;
    }

}
