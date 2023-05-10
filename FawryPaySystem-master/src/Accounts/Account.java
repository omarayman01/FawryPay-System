package Accounts;

public abstract class Account {


    protected String email;
    protected String password;
    public int show_options(){return 0;};

    public String get_mail() {
        return email;
    }

    public String get_password() {
        return password ;
    }


}

