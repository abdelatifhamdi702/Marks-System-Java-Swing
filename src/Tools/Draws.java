/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Abdelatif Hamdi
 */
public class Draws {
    private JFrame form;
    public int Border = 1 ;
    public Color couleur = Color.BLACK;
    
    
    public Draws (JFrame form){
    this.form=form;
    }
    
    public void DrowLine(int x1, int y1 ,int x2 , int y2 ){
    JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(Border));
        g2.setColor(couleur);
        g2.drawLine(x1, y1, x2, y2);
    }};
    p.setBounds(0, 0, form.getWidth(), form.getHeight());
    form.add(p);}
    
    public void Rectangle(int x, int y ,int width , int height ){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawRect(x, y, width, height);
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}
    
 public void Square(int x, int y ,int l){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawRect(x, y, l, l);
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
 
  public void Oval(int x, int y ,int width , int height ){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawOval(x, y , width , height );
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
  
  public void Circle(int x, int y ,int l){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawOval(x, y, l, l);
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
  
  public void Polygon(int xPoints[], int yPoints[] ,int nbrPoints){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawPolygon(xPoints, yPoints,nbrPoints);
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
  public void Text(int x, int y ,String text,String fontName ,int fontSize){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        Font font = new Font(fontName,Font.BOLD,fontSize);
        g2.setFont(font);
        g2.drawString(text, x, y);
        
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}

  public void Image(int x, int y ,String path){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        
        try {
        Graphics2D g2 = (Graphics2D) g;
        File imgfile = new File(path);            
            Image img = ImageIO.read(imgfile);
            Image newimg = img.getScaledInstance(form.getWidth()-50, form.getHeight()-50, Image.SCALE_AREA_AVERAGING);
            g2.drawImage(newimg, x, y, form);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
  public void RoundRec(int x, int y ,int width , int height , int BorderRound ){
        JPanel p = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(couleur);
        g2.setStroke(new BasicStroke(Border));
        g2.drawRoundRect(x, y, width, height, BorderRound, BorderRound);
    }};
        form.add(p);
        p.setBounds(0, 0, form.getWidth(), form.getHeight());
}   
  
}

