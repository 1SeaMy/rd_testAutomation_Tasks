package Singleton;
public class Main {
    public static void main(String[] args) {
        PasswordList passwordList1 = PasswordList.getInstance();
        passwordList1.resetList();

        PasswordList passwordList2 = PasswordList.getInstance();

        System.out.println(passwordList1 == passwordList2);

        passwordList1.addPassword("deniz");
        passwordList2.addPassword("batu"); //add passwordList2

        passwordList1.removePassword("batu"); //remove passwordList1 =??? :)

        passwordList1.printPassword();
        passwordList2.printPassword();
    }
}