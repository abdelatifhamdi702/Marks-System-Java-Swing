/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Abdelatif Hamdi
 */
public class JMyBottom extends  JButton{
    public JMyBottom(){
    setOpaque(false); // supprimer le vide apres la modification
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        //interieur
    g.setColor(new Color(70,130,180));
    g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    super.paintComponent(g);};
    @Override
    protected void paintBorder(Graphics g)    {
        //bordure
    g.setColor(Color.BLUE);
    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);    
    };
    
    
}
