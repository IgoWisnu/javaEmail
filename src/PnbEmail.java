public class PnbEmail extends Email{
    private String access;
    private int capacity;
    private String NIM;
    public String getAccess() {
        return access;
    }
    public void setAccess(String access) {
        this.access = access;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getNIM() {
        return NIM;
    }
    PnbEmail(){

    }
    PnbEmail(String email, String password, String NIM, String access, int capacity){
        this.setEmail(email);
        this.setPassword(password);
        this.setNIM(NIM);
        this.setAccess(access);
        this.setCapacity(capacity);
    }
    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
    public void display() {
        System.out.println("---Email Detail---");
        System.out.println("Email : "+getEmail());
        System.out.println("Password : "+getPassword());
        System.out.println("NIM : "+getNIM());
        System.out.println("---------------");
    }
}
