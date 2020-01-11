/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

/**
 *
 * @author Admin
 */
public class Helper {

    private static int i = 1;

    public static int nextNumGenerator() {
//        SecureRandom random = new SecureRandom();
//        int num = random.nextInt(10);
        return i++;
    }

}
