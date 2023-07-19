public class Email {
    private String name;
    private String password;

    public String getEmail() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void display(){
        System.out.println(getEmail());
    }
}
