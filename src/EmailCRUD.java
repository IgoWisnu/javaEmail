import java.util.ArrayList;

public abstract class EmailCRUD {

    public abstract void addEmail(PnbEmail pnbEmail);
    public abstract void deleteEmail(int index);
    public abstract int editEmail(int index);
    public abstract void display();
}
