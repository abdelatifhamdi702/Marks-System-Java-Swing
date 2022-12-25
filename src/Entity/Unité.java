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
public class Unité implements MainData{
    private int NumU;
    private String NomU;
    private int CoefU;

    
    @Override
    public void add() {
        String insert ="insert into Unité values("
                +NumU+",'"+NomU+"',"+CoefU+")";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("L'Unité est ajouté");
        }}

    @Override
    public void update() {
        String update ="update Unité set " + "NomU='"+NomU+"',"
        +"CoefU="+CoefU+" where NumU="+NumU;
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("L'Unité est mis à jour");}
     
    }

    @Override
    public void delete() {
        String delete="delete from Unité where NumU="+NumU;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("L'Unité est supprimé");}

    }

    @Override
    public String getAutoNumber() {
        String auto = db.go.getAutoNumber("Unité", "NumU");
        return auto;

    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTableWithTableName("Unité", table);
    }

    @Override
    public void getOneRow(JTable table) {
       String select="select * from Unité where NumU="+NumU;
       db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTableWithStatement(Statement, table);

    }

    @Override
    public String getValueByName(String Name) {
      String select ="select NumU from Unité where NomU='"
             +Name+"'" ;
      String val =(String) db.go.getTableData(select).Items[0][0];
      return val;
    }

    @Override
    public String getNameByValue(String Value) {
        String select ="select NomU from Unité where NumU='"
             +Value+"'" ;
      String Name =(String) db.go.getTableData(select).Items[0][0];
      return Name;

    }

    public int getNumU() {
        return NumU;
    }

    public void setNumU(int NumU) {
        this.NumU = NumU;
    }

    public String getNomU() {
        return NomU;
    }

    public void setNomU(String NomU) {
        this.NomU = NomU;
    }

    public int getCoefU() {
        return CoefU;
    }

    public void setCoefU(int CoefU) {
        this.CoefU = CoefU;
    }

   
    
}
