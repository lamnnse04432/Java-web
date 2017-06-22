/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.security.MessageDigest;

/**
 *
 * @author lamtu
 */
public class Encryption {
    
    public  String encryption(String str) {
       
        byte[] defaultBytes = str.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            str = hexString + "";
        } catch (Exception e) {
            e.getMessage();
        }
        return str;
    }
    
        public static void main(String[] args) {
          Encryption e=new Encryption();
          String a=e.encryption("1234");
            System.out.println(a);
    }
}
