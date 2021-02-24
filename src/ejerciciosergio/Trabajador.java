/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosergio;

/**
 *
 * @author Zhel-PC
 */
public class Trabajador {

    private String nombre;
    private int categoria;
    private int horas, horasMaxBase;

    public Trabajador(String nombre, int categoria, int horas, int horasMaxBase) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.horas = horas;
        this.horasMaxBase = horasMaxBase;
    }

    public int getHorasMaxBase() {
        return horasMaxBase;
    }

    public void setHorasMaxBase(int horasMaxBase) {
        this.horasMaxBase = horasMaxBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
