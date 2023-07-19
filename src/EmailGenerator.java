public interface EmailGenerator {

    public String generatedEmail(String name);
    public String changePass();
    public String setAccess(String NIM);
    public void setAlternateEmail(String email);
}
