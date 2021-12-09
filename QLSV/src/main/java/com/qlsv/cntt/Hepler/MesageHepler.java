/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Hepler;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author NguyenCongPC
 */
public class MesageHepler {
    public static void showMessageDialog(Component component, String content, 
            String title){
        JOptionPane.showMessageDialog(component, title,content, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(Component component, String content, 
            String title){
        JOptionPane.showMessageDialog(component, title,content, JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDialog(Component component, String content, 
            String title){
        int chose = JOptionPane.showConfirmDialog(component, title, content,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return chose;
    }
}
