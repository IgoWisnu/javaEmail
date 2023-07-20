import java.util.ArrayList;
import java.util.Scanner;

public class ProblemEmailCRUD extends EmailCRUD{
    Scanner input = new Scanner(System.in);
    public ArrayList<PnbEmail> problemEmail = new ArrayList<PnbEmail>();
    PnbEmail pnbEmail = new PnbEmail();
    @Override
    public void addEmail(PnbEmail pnbEmail) {
        this.pnbEmail = pnbEmail;
        System.out.println("This?"+pnbEmail.getEmail());
        problemEmail.add(this.pnbEmail);
    }

    @Override
    public void deleteEmail(int index) {
        problemEmail.remove(index);
    }

    @Override
    public int editEmail(int index) {
        PnbEmail email = problemEmail.get(index);
        int check = -1;
        System.out.println("1.Edit Password\n2.Edit Akses\n3.Edit Kapasitas\nSilahkan pilih menu : ");
        int answer = input.nextInt();
        input.nextLine();
        switch (answer){
            case 1 :
                System.out.println("Masukan password baru :");
                String newPassword = input.nextLine();
                email.setPassword(newPassword);
                problemEmail.set(index, email);
                check = confirmEdit(check);
                break;
            case 2 :
                System.out.println("Masukan akses baru :");
                String newAccess = input.nextLine();
                email.setAccess(newAccess);
                problemEmail.set(index, email);
                check = confirmEdit(check);
                break;
            case 3 :
                System.out.println("Masukan kapasitas baru :");
                int newCapacity = input.nextInt();
                email.setCapacity(newCapacity);
                problemEmail.set(index, email);
                System.out.println("pulihkan kembali email? (y/t)");
                check = confirmEdit(check);
                break;
        }
        return check;
    }

    @Override
    public void display(){
        int index =1;
        System.out.println("-----Problem Email-----");
        for (PnbEmail email : problemEmail) {
            System.out.println(index+". "+email.getEmail()+" "+email.getPassword()+" "+email.getAccess()+" "+email.getCapacity());
            index++;
        }
        System.out.println("===========================================");
    }

    public int confirmEdit(int confirm){
        System.out.println("pulihkan kembali email? (y/t)");
        String sendback = input.nextLine();
        if(sendback.equals("y")){
            confirm = 1;
        }
        return confirm;
    }
    public boolean isEmailExist(int index){
        if(index <= problemEmail.size()){
            return true;
        }
        return false;
    }
}
