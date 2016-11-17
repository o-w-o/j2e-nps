/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.util;

/**
 *
 * @author dot
 */
public class JSONEx {
    public static String setStatusCode(int statusCode, String data) {
        return "{statusCode:" + statusCode + ",data="+ data + "}";
    }
}
