/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.util;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @author dot
 */
public class I18NDemo {
    public static void main(String[] args) {
        String language;
        String country;
        if (args.length != 2) {
            language = "en";
            country = "US";
        } else {
            
            language = args[0];
            country = args[1];
        }
        ResourceBundle msg;
        Locale currentLocal;
        currentLocal = new Locale(language, country);
        
        msg = ResourceBundle.getBundle("ApplicationResource", currentLocal);
        
        System.out.println(msg.getString("hello"));
        System.out.println(msg.getString("greeting"));
        System.out.println(msg.getString("bye"));
    }
}
