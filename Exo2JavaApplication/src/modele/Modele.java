/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import views.View;
import java.util.ArrayList;

/**
 *
 * @author guigu
 */
public class Modele {
    private ArrayList<View> myViews;
    
    public Modele(){
        myViews = new ArrayList<View>();
    }
    
    
    public void addView(View v){
        myViews.add(v);
    }
    
    public void update(){
       for(View v : myViews)
           v.update();
    }
    
    
}
