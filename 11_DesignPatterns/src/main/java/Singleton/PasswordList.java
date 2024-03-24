package Singleton;

import java.util.ArrayList;
import java.util.List;

public class PasswordList {
    private static PasswordList instance;
    private ArrayList<String> passwordList;

    private PasswordList() {
        passwordList = new ArrayList<>();
    }

    public static synchronized PasswordList getInstance() {
        if (instance == null) {
            instance = new PasswordList();
        }
        return instance;
    }

    public ArrayList<String> getPasswordList(){
        return passwordList;
    }
    public void addPassword(String password) {
        passwordList.add(password);
    }

    public void removePassword(String password) {
        passwordList.remove(password);
    }

    public int getLength(){
        return passwordList.size();
    }
    public void resetList() {
        passwordList=new ArrayList<>();
    }

    public void printPassword() {
        for (String password : passwordList) {
            System.out.println(password);
        }
    }
}