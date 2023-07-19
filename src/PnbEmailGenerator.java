import java.util.Scanner;

public class PnbEmailGenerator implements EmailGenerator{
    Scanner input = new Scanner(System.in);
    private String name;
    private String password;
    private String NIM;
    private String email;


    @Override
    public String generatedEmail(String name) {
        this.name = name;

        String rawName[] = name.split(" ");

        int nameLength = rawName.length;
        if(nameLength > 1){
            email = (rawName[0] + rawName[nameLength-1]+"@pnb.id");
        }
        else {
            email = (name+"@pnb.id");
        }
        return email;
    }

    @Override
    public String changePass() {
        this.password = password;
        System.out.println("Masukan password baru : ");
        this.password = input.nextLine();
        System.out.println("Password changed");
        return this.password;
    }

    @Override
    public String setAccess(String NIM) {
        this.NIM = NIM;
        char indexJurusan = this.NIM.charAt(4);

        switch (indexJurusan){
            case '1' :
                return "E-Lab Teknik Sipil";
            case '2' :
                return "E-Lab Teknik Mesin";
            case '3' :
                return "E-Lab Teknik Elektro";
            case '6' :
                return "Office Student 365 Akutansi";
            case '7':
                return "E-book Administrasi Bisnis";
            case '8':
                return "E-book Pariwisata";
            default:
                return "Tidak ditemukan";
        }
    }

    public int setCapacity(String NIM) {
        this.NIM = NIM;
        char indexJurusan = this.NIM.charAt(4);

        switch (indexJurusan){
            case '1' :
                return 10;
            case '2' :
                return 10;
            case '3' :
                return 10;
            case '6' :
                return 2;
            case '7':
                return 5;
            case '8':
                return 5;
            default:
                return 5;
        }
    }

    @Override
    public void setAlternateEmail(String email) {

    }

    public String randomPassword(int lenght){
        String passwordChar = "";
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#%";
        for(int i=0; i<lenght; i++){
            int randomChar = (int) (Math.random() * passwordSet.length());
            passwordChar = passwordChar + passwordSet.charAt(randomChar);
        }
        return passwordChar;
    }
    public void addEmail(){

    }
    private int emailExistCheck(String email){
        return 0;
    }

}
