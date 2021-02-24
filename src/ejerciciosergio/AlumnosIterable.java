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
public class AlumnosIterable implements Iterator {

    private ArrayList<Alumno> alumnos;
    private int currentIdx;
    
    public AlumnosIterable() {
        currentIdx = 0;
        alumnos = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return currentIdx == alumnos.size() - 1;
    }

    @Override
    public Alumno next() {
        Alumno alumnoADevolver = alumnos.get(currentIdx);
        currentIdx++;
        return alumnoADevolver;
    }

}
