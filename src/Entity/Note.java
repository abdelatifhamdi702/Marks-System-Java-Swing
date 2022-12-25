/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Tools.Tools.Message;
import javax.swing.JTable;

/**
 *
 * @author Abdelatif Hamdi
 */
public class Note implements MainData{
    private int NumE;
    private String NomM;
    private int Semstre;
    private int Année;
    private String Niveau;
    private double TD; 
    private double TP; 
    private double Examen; 
    private double NoteF; 

    

    @Override
    public void add() {
        String insert ="insert into Note values("
                +NumE+",'"+NomM+"',"+Semstre+","+Année+","+"'"+Niveau+"',"
                +""+TD+","+TP+","+Examen+","+NoteF+ ")";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("La Note est ajouté");
    }}
    

    @Override
    public void update() {
       String update ="update Note set " + "Semestre="+Semstre+","
        +"Année="+Année+","+"Niveau='"+Niveau+"', TD="+TD+
        ",TP="+TP+",Examen="+Examen+", NoteF="+NoteF+" where ( NumE="+NumE+" and NomM='"+NomM+"')";
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("La Note est mis à jour");}
     
    }
    

    @Override
    public void delete() {
       String delete="delete from Note where ( NumE="+NumE+" and NomM='"+NomM+"')";
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("La Note est supprimé");}}

    @Override
    public String getAutoNumber() {
        Message("Cette Méthode n'existe pas dans la class Note car il n'ya pas un numéro de Note");
     return null;    }

    @Override
    public void getAllRows(JTable table) {
     db.go.fillToJTableWithTableName("NoteWithName", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select="select * from NoteWithName where ( NumE="+NumE+" and NomM='"+NomM+"')";
       db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTableWithStatement(Statement, table);
    }

    @Override
    public String getValueByName(String Name) {
Message("Cette Méthode n'existe pas dans la class Note car il n'ya pas un numéro de Note");
     return null;   }

    @Override
    public String getNameByValue(String Value) {
Message("Cette Méthode n'existe pas dans la class Note car il n'ya pas un numéro de Note");
     return null;    }

    public int getNumE() {
        return NumE;
    }

    public void setNumE(int NumE) {
        this.NumE = NumE;
    }

    public String getNomM() {
        return NomM;
    }

    public void setNomM(String NomM) {
        this.NomM = NomM;
    }

    public int getSemstre() {
        return Semstre;
    }

    public void setSemstre(int Semstre) {
        this.Semstre = Semstre;
    }

    public int getAnnée() {
        return Année;
    }

    public void setAnnée(int Année) {
        this.Année = Année;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }

    public double getTD() {
        return TD;
    }

    public void setTD(double TD) {
        this.TD = TD;
    }

    public double getTP() {
        return TP;
    }

    public void setTP(double TP) {
        this.TP = TP;
    }

    public double getExamen() {
        return Examen;
    }

    public void setExamen(double Examen) {
        this.Examen = Examen;
    }

    public double getNoteF() {
        return NoteF;
    }

    public void setNoteF(double NoteF) {
        this.NoteF = NoteF;
    }
    
}
