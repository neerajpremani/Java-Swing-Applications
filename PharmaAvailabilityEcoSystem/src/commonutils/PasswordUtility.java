/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.security.SecureRandom;

/**
 *
 * @author Admin
 */
public class PasswordUtility {

    public static String createPassword(String un) {
//        Random randomInts = new Random();
//        randomInts.ints(0, 9);

        SecureRandom random = new SecureRandom();
        int num = random.nextInt(1000000);
        String formatted = String.format("%06d", num);
        String password = un + "@" + formatted;
        System.out.println(un + "|" + password);
        return password;
    }
}
