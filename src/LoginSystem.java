/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    

public class LoginSystem {

    String username;
    String password;
    String firstName;
    String lastName;
    String cellphone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {

        if (password.length() < 8) return false;

        boolean upper = false;
        boolean number = false;
        boolean special = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            if (Character.isDigit(c)) number = true;
            if (!Character.isLetterOrDigit(c)) special = true;
        }

        return upper && number && special;
    }

    public boolean checkCellphoneNumber(String cellphone) {
        return cellphone.startsWith("+27") && cellphone.length() == 12;
    }

    public String registerUser(String u, String p, String f, String l, String cell) {

        if (!checkUserName(u)) return "Invalid username";
        if (!checkPasswordComplexity(p)) return "Invalid password";
        if (!checkCellphoneNumber(cell)) return "Invalid cellphone";

        username = u;
        password = p;
        firstName = f;
        lastName = l;
        cellphone = cell;

        return "User successfully registered!";
    }

    public boolean loginUser(String u, String p) {
        return u.equals(username) && p.equals(password);
    }

    public String returnLoginStatus(boolean status) {
        return status
                ? "Welcome " + firstName + " " + lastName
                : "Login failed";




    }
}

