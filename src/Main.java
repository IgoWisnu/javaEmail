import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static PnbEmailGenerator generator = new PnbEmailGenerator();
    public static PnbEmailCRUD pnbEmailCRUD = new PnbEmailCRUD();
    public static ProblemEmailCRUD problemEmailCRUD = new ProblemEmailCRUD();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PnbEmail email1 = new PnbEmail();
        email1.setEmail("alok@pnb.id");
        email1.setPassword("alok123");
        email1.setNIM("2215354040");
        email1.setAccess("E-Lab Teknik Elektro");
        email1.setCapacity(10);
        pnbEmailCRUD.pnbEmail.add(email1);

        PnbEmail email2 = new PnbEmail("IWisnu@pnb.id", "wisnuwardana", "2215324010","E-Lab Teknik Elektro", 10);
        email2.setEmail(email2.getEmail().toLowerCase());
        pnbEmailCRUD.addEmail(email2);

        PnbEmail email3 = new PnbEmail("NiDiah@pnb.id", "diah123", "2215324010", "E-Lab Teknik Elektro", 10);
        pnbEmailCRUD.addEmail(email3);
        email3.setEmail(email3.getEmail().toLowerCase());
        pnbEmailCRUD.display();

        int answer;

        System.out.println("--- EMAIL ADMINISTRATION PNB ---");
        System.out.println("--------------------------------");
        do{
            System.out.println("Pilih menu : ");
            System.out.println("1.Check email list\t\t| 4.Ads to problem email\n2.Generate new email\t| 5.Problem email\n3.Delete email\t\t\t| 6.Exit");
            answer = input.nextInt();

            switch (answer){
                case 1 :
                    pnbEmailCRUD.display();
                    break;
                case 2 :
                    getUserData();
                    break;
                case 3 :
                    pnbEmailCRUD.display();
                    System.out.println("Masukan nomor email yang ingin dihapus :");
                    int index = input.nextInt();
                    if(pnbEmailCRUD.isEmailExist(index-1) == true){
                        pnbEmailCRUD.deleteEmail(index-1);
                    }
                    else {
                        System.out.println("Index tidak ditemukan");
                    }
                    break;
                case 4 :
                    pnbEmailCRUD.display();
                    System.out.println("Masukan nomor email yang ingin dipindahkan :");
                    index = input.nextInt();
                    sendEmail(index-1);
                    break;
                case 5 :
                    problemEmailMenu();
                    break;
                default :
                    System.out.println("Input angka 1-6");
            }
        }while (answer != 6);

    }
    public static void sendEmail(int index){
        PnbEmail selectEmail = pnbEmailCRUD.pnbEmail.get(index);
        System.out.println("selected : "+selectEmail.getEmail());
        pnbEmailCRUD.pnbEmail.remove(index);
        problemEmailCRUD.addEmail(selectEmail);
    }
    public static void sendBack(int index){
        PnbEmail selectedEmail = problemEmailCRUD.problemEmail.get(index);
        pnbEmailCRUD.addEmail(selectedEmail);
        problemEmailCRUD.problemEmail.remove(index);
    }
    public static void problemEmailMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("----Problem Email Menu----");
        int answer;
        int index;
        do{
            System.out.println("1.Check problem email list \n2.Edit email \n3.Delete email\n4.Send back email\n5.Exit");
            answer = input.nextInt();

            switch (answer){
                case 1 :
                    problemEmailCRUD.display();
                    break;
                case 2 :
                    problemEmailCRUD.display();
                    System.out.println("masukan no email yang ingin di edit :");
                    index = input.nextInt();
                    PnbEmail email = problemEmailCRUD.problemEmail.get(index-1);
                    email.display();
                    int returnback = problemEmailCRUD.editEmail(index-1);
                    if(returnback == 1){
                        sendBack(index-1);
                    }
                    break;
                case 3 :
                    problemEmailCRUD.display();
                    System.out.println("masukan no email yang ingin di edihapus :");
                    index = input.nextInt();
                    problemEmailCRUD.deleteEmail(index-1);
                    break;
                case 4 :
                    problemEmailCRUD.display();
                    System.out.println("masukan no email yang ingin di pindahkan : :");
                    index = input.nextInt();
                    sendBack(index-1);
                    break;
            }
        }
        while (answer!=5);
    }
    public static int isEmailExist(String emailName, String namalengkap){
        boolean check;
        int existCount = 1;
        do {
            check = false;
            for (PnbEmail email : pnbEmailCRUD.pnbEmail) {
                if (email.getEmail().equals(emailName)) {
                    existCount++;
                    emailName = generator.generatedEmail(namalengkap+existCount);
                    System.out.println("Check : "+emailName);
                    check = true;
                }
            }
            for (PnbEmail email : problemEmailCRUD.problemEmail) {
                if (email.getEmail().equals(emailName)) {
                    existCount++;
                    emailName = generator.generatedEmail(namalengkap+existCount);
                    System.out.println("Check : "+emailName);
                    check = true;
                }
            }
        }
        while (check == true);
        return existCount;
    }
    public static void getUserData() {
        System.out.println("--- GENERATE EMAIL ---");
        System.out.println("Silahkan masukan nama lengkap :");
        String namalengkap = input.nextLine();
        //lowercase input
        namalengkap = namalengkap.toLowerCase();

        //NIM check
        boolean flag;
        String NIM;
        do{
            flag = false;
            System.out.println("Silahkan masukan NIM :");
            NIM = input.nextLine();
            //NIM check
            if(nimCheck(NIM) == true){
                flag = true;
                System.out.println("NIM sudah terdaftar!");
            }
        }while (flag != false);
        //generate email, password, and access
        String resultEmail = generator.generatedEmail(namalengkap);
        int isEmailExist = isEmailExist(resultEmail, namalengkap);
        if(isEmailExist > 1){
            System.out.println("same");
            resultEmail = generator.generatedEmail(namalengkap+isEmailExist);
        }
        String resultPassword = generator.randomPassword(8);
        String access = generator.setAccess(NIM);
        int capacity = generator.setCapacity(NIM);

        System.out.println("Email : "+resultEmail);
        System.out.println("Password : "+ resultPassword);
        System.out.println("Akses : "+ access);
        System.out.println("Kapasitas : "+capacity+" GB");

        //confirm add to list
        System.out.println("Apakah email sudah sesuai? (y/t)");
        String answer = input.nextLine();
        if(answer.equals("y")){
            System.out.println("Apakah anda ingin mengganti password saat ini?");
            answer = input.nextLine();
            if(answer.equals("y")){
                resultPassword = generator.changePass();
            }
        }
        else {
            return;
        }
        PnbEmail newEmail = new PnbEmail();
        newEmail.setEmail(resultEmail);
        newEmail.setPassword(resultPassword);
        newEmail.setNIM(NIM);
        newEmail.setAccess(access);
        newEmail.setCapacity(capacity);
        pnbEmailCRUD.addEmail(newEmail);
    }
    public static boolean nimCheck(String NIM){
        boolean flag = false;
        for (PnbEmail email : pnbEmailCRUD.pnbEmail){
            if(email.getNIM().equals(NIM)){
                flag = true;
                break;
            }
        }
        for (PnbEmail email : problemEmailCRUD.problemEmail){
            if(email.getNIM().equals(NIM)){
                flag = true;
                break;
            }
        }
        return flag;
    }

}