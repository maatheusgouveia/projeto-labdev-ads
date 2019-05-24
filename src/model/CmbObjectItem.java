/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 */
public class CmbObjectItem {
    private String name;
    private int index;

    public void setName(String name) {
        this.name = name;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
    
    @Override
    public String toString() {
      return name;
    }
}
