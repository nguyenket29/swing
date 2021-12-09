/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Hepler;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author NguyenCongPC
 */
public class Validator {
    public static void validatorEmpty(JTextField field, StringBuilder sb , String error){
        if(field.getText().equals("")){
            sb.append(error).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else {
           field.setBackground(Color.white);
        }
    }
    
    public static void validatorEmpty(JPasswordField field, StringBuilder sb , String error){
        String pass = new String(field.getPassword());
        if(pass.equals("")){
            sb.append(error).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else {
           field.setBackground(Color.white);
        }
    }
}
