/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kafka.springbootkafkaconsumerexample;
import javax.swing.JOptionPane;
/**
 *
 * @author dn
 */
public class PopUp {
    public static void infoBox(String name, String id)
    {
        JOptionPane.showMessageDialog(null, "NAME : " + name, "NEW PLANE "
                + "(" + id + ")", JOptionPane.INFORMATION_MESSAGE);
    }
}
