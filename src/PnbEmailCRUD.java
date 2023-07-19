import java.util.ArrayList;
import java.util.Scanner;

public class PnbEmailCRUD extends EmailCRUD{
    Scanner input = new Scanner(System.in);
    ProblemEmailCRUD problemEmailCRUD = new ProblemEmailCRUD();
    public ArrayList<PnbEmail> pnbEmail = new ArrayList<PnbEmail>();

    @Override
    public void addEmail(PnbEmail rawEmail) {
        pnbEmail.add(rawEmail);
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
        System.out.println("---All Email---");
        for (PnbEmail email : pnbEmail) {
            System.out.println(index+". "+email.getEmail()+" "+email.getPassword());
            index++;
        }
        System.out.println("---------------");
        for (PnbEmail email : problemEmailCRUD.problemEmail) {
            System.out.println(index+". "+email.getEmail()+" "+email.getPassword());
            index++;
        }
    }

}
