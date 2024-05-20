package se.norrwing.lek1;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PasswordHashService PSH = new PasswordHashService();
    static HashMap<String, String> users = new HashMap<String, String>();
    public static void main(String[] args) {

        JOptionPane.showConfirmDialog(
                null,
                "Registrera dig här",
                "Registration",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        String userName = JOptionPane.showInputDialog("Input username");
        String password = JOptionPane.showInputDialog("Input password");

        String hashedPassword = PSH.hashPassword(password);
        users.put(userName, hashedPassword);



        JOptionPane.showConfirmDialog(null,"Please login", "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

        String userName2 = JOptionPane.showInputDialog("Input userName");
        String password2 = JOptionPane.showInputDialog("Input password");

        String hashedPW = verifyUser(userName2);

        if(PSH.checkPassword(password2, hashedPassword)){
            System.out.println("Logged in");
        } else {
            System.out.println("User was unable to be verified");
        }




    }

    public static String verifyUser(String userName) {
        return users.get(userName);
    }

}
