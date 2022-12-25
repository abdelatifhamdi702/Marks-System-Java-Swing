/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JTable;

/**
 *
 * @author Abdelatif Hamdi
 */
public interface MainData {
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getOneRow(JTable table);
    public void getCustomRows(String Statement , JTable table );
    public String getValueByName(String Name);
    public String getNameByValue(String Value);
}
