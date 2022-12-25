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
public class Module implements MainData{
    
    
    private String NomM;
    private int CoefM;
    private int NumU;

    

    @Override
    public void add() {
String insert ="insert into Module values('"
                +NomM+"',"+CoefM+","+NumU+")";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("Le Module est ajouté");
        }}

    @Override
    public void update() {
        String update ="update Module set "
        +"CoefM="+CoefM+","+"NumU="+NumU+" where NomM='"+NomM+"'";
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("Le Module  est mis à jour");}    }

    @Override
    public void delete() {
        String delete="delete from Module where NomM='"+NomM+"'";
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("Le Module est supprimé");}    }

    @Override
    public String getAutoNumber() {
        Message("Cette Méthode n'existe pas dans la class module car il n'ya pas un numéro de module");
     return null;
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTableWithTableName("Module", table);
    }

    @Override
    public void getOneRow(JTable table) {
     String select="select * from Module where NomM='"+NomM+"'";
     db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
    db.go.fillToJTableWithStatement(Statement, table);    }

    @Override
    public String getValueByName(String Name) {
      Message("Cette Méthode n'existe pas dans la class module car il n'ya pas un numéro de module");
      return null;    }

    @Override
    public String getNameByValue(String Value) {
Message("Cette Méthode n'existe pas dans la class module car il n'ya pas un numéro de module");
      return null;    }
    
    public int getCoefByName(String Name){
    String select ="select CoefM from Module where NomM='"
             +Name+"'" ;
      String val =(String) db.go.getTableData(select).Items[0][0];
      return Integer.parseInt(val);    
    
    
    
    }

    public String getNomM() {
        return NomM;
    }

    public void setNomM(String NomM) {
        this.NomM = NomM;
    }

    public int getCoefM() {
        return CoefM;
    }

    public void setCoefM(int CoefM) {
        this.CoefM = CoefM;
    }

    public int getNumU() {
        return NumU;
    }

    public void setNumE(int NumU) {
        this.NumU = NumU;
    }
    
}
