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
public class Categoria {
    private int codigo;
    private double precioExtra;
    private double sueldoBase;
    private String nombre;
    
    public Categoria(int codigo, String nombre, double sueldoBase, double precioExtra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.precioExtra = precioExtra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
