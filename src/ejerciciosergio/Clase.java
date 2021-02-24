/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosergio;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Zhel-PC
 */
public class Clase implements Iterable {
    
    AlumnosIterable alumnos;
    private int currentIdx;
    
    public Clase() {
        currentIdx = 0;
        alumnos = new AlumnosIterable();
    }
    
    //getters setters

    @Override
    public Iterator iterator() {
        return alumnos;
    }
}
