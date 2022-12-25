/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Tools.Tools.Message;
import static db.go.getRes;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Abdelatif Hamdi
 */
public class Etudiant implements MainData{
    private int NumE;
    private String NomE;
    private String address;
    private String Email;
    private String NumTélé;
    private String DateN;
    private String Spécialité ;
    private String Photo;
    
    @Override
    public void add() {
        String insert ="insert into Etudiant values("
                +NumE+",'"+NomE+"','"+DateN+"','"+address+"','"+NumTélé+"','"+Email+"','"+Spécialité+"',(SELECT * FROM OPENROWSET(BULK '"+Photo+"', SINGLE_BLOB)AS x ) )";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("L'Etudiant est ajouté");
    }}
    

    @Override
    public void update() {
       String update = "update Etudiant set NomE='"+NomE+"',DateN='"+DateN+"', Adresse='"+address+"',NumTélé='"+NumTélé+"',Email='"+Email+"',Spécialité='"+Spécialité+"',Photo=(SELECT * FROM OPENROWSET(BULK '"+Photo+"', SINGLE_BLOB)AS x ) where NumE="+NumE;
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("L'Etudiant est mis à jour");}
     
    }
    

    @Override
    public void delete() {
       String delete="delete from Etudiant where NumE="+NumE;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("L'Etudiant est supprimé");}}

    @Override
    public String getAutoNumber() {
        String auto = db.go.getAutoNumber("Etudiant", "NumE");
        return auto;    }

    @Override
    public void getAllRows(JTable table) {
     db.go.fillToJTableWithTableName("Etud_Sans_Img", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select="select * from Etud_Sans_Img where NumE="+NumE;
       db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTableWithStatement(Statement, table);
    }

    @Override
    public String getValueByName(String Name) {
     String select ="select NumE from Etudiant where NomE='"
             +Name+"'" ;
      String val =(String) db.go.getTableData(select).Items[0][0];
      return val;    }

    @Override
    public String getNameByValue(String Value) {
String select ="select NomE from Etudiant where NumE='"
             +Value+"'" ;
      String Name =(String) db.go.getTableData(select).Items[0][0];
      return Name;    }
    
    public Image getPhotoByNumE(String Value){
        try {
            String select ="select Photo from Etudiant where NumE='"
             +Value+"'" ;
    //String p = (String) db.go.getTableData(select).Items[0][0];
      ResultSet rs = getRes(select);
            byte[] buffer = rs.getBytes(1);
            ImageIcon icon = new ImageIcon(buffer);
            return icon.getImage();
        } catch (SQLException ex) {
            Message(ex); return null;
        }
      
              
    
    }
    public int getNumE() {
        return NumE;
    }

    public void setNumE(int NumE) {
        this.NumE = NumE;
    }

    public String getNomE() {
        return NomE;
    }

    public void setNomE(String NomE) {
        this.NomE = NomE;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNumTélé() {
        return NumTélé;
    }

    public void setNumTélé(String NumTélé) {
        this.NumTélé = NumTélé;
    }

    public String getDateN() {
        return DateN;
    }

    public void setDateN(String DateN) {
        this.DateN = DateN;
    }

    public String getSpécialité() {
        return Spécialité;
    }

    public void setSpécialité(String Spécialité) {
        this.Spécialité = Spécialité;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    
    
}
