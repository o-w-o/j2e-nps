/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dot
 */
public class SessionEx{
    
    public static void setSession(HttpServletRequest req, String key, String value) {
        req.getSession().setAttribute(key, value);
    }
}
