/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosergio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Zhel-PC
 */
public class EjercicioSergio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Categoria> categoriasProfesionales = new ArrayList<Categoria>();
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

        //añadir categorías profesionales al arraylist de categorias
        Categoria becario = new Categoria(0, "Becario", 700.00, 8.50); //id, nombre cat prof, sueldo base, precio hora extra
        categoriasProfesionales.add(becario);

        categoriasProfesionales.add(new Categoria(1, "Desarrollador Junior", 900.00, 10.00));
        categoriasProfesionales.add(new Categoria(2, "Desarrollador Senior", 1500.00, 19.25));
        categoriasProfesionales.add(new Categoria(3, "Arquitecto de Sistemas", 2300.00, 40.00));
        
        trabajadores.add(new Trabajador("Juanito", 0, 0, 240));
        trabajadores.add(new Trabajador("Menganito", 1, 0, 240));
        trabajadores.add(new Trabajador("Pepe", 1, 0, 240));
        trabajadores.add(new Trabajador("Eustaquio", 2, 0, 240));
        trabajadores.add(new Trabajador("Eusebio", 3, 0, 240));
        

        System.out.println("1. Mostrar precio horas extra según categoría profesional.\n"
                + "2. Listar trabajadores y sus categorías profesionales.\n"
                + "3. Imputar horas extra.\n"
                + "4. Listar horas extra trabajadas.\n"
                + "5. Mostrar coste total del ejercicio económico de la empresa.\n"
                + "0. Salir.\n");

        int opt = scan.nextInt();
        scan.nextLine(); //consume newline

        while (opt != 0) {
            switch (opt) {
                case 1:
                    listOvertimePrice(categoriasProfesionales);
                    break;
                case 2:
                    listWorkersCategory(trabajadores, categoriasProfesionales);
                    break;
                case 3:
                    inputOvertime(trabajadores, categoriasProfesionales);
                    break;
                case 4:
                    listWorkersOvertime(trabajadores, categoriasProfesionales);
                    break;
                case 5:
                    showTotalCost(trabajadores, categoriasProfesionales);
                    break;
                default:
                    break;
            }

            System.out.println("\n\n\n1. Mostrar precio horas extra según categoría profesional.\n"
                    + "2. Listar trabajadores y sus categorías profesionales.\n"
                    + "3. Imputar horas extra.\n"
                    + "4. Listar horas extra trabajadas.\n"
                    + "5. Mostrar coste total del ejercicio económico de la empresa.\n"
                    + "0. Salir.\n");

            opt = scan.nextInt();
            scan.nextLine(); //consume newline
        }
    }

    public static void listOvertimePrice(ArrayList<Categoria> arr) {
        //listar precios de horas extra de las categorías profesionales
        for (Categoria c : arr) {
            System.out.println("Nombre categoría: " + c.getNombre() + "\tPrecio de hora extra: " + c.getPrecioExtra());
        }
    }

    public static void listWorkersCategory(ArrayList<Trabajador> arr, ArrayList<Categoria> categorias) {
        //listar trabajadores y su categoría profesional
        for (Trabajador t : arr) {
            int idCategoriaTrabajador = t.getCategoria();
            String catTrabajadorStr = getCategoriaByCodigo(idCategoriaTrabajador, categorias).getNombre();
            
            System.out.println("Nombre trabajador: " + t.getNombre() + "\tCategoría profesional: " + catTrabajadorStr);
        }
    }

    public static void inputOvertime(ArrayList<Trabajador> trabajadores, ArrayList<Categoria> categorias) {
        Scanner scan = new Scanner(System.in);
        //TODO: imputar categoria y trabajador y si existe imputar horas extras. repetir hasta que se introduzca "FIN"
        System.out.println("introduzca nombre del trabajador: ");
        String nombreTrabajador = scan.nextLine();
        
        while (!nombreTrabajador.equalsIgnoreCase("FIN")) {
            
            //comprobar que existe el trabajador y tiene la categoría profesional especificada
            if (trabajadorExisteEnArrayList(nombreTrabajador, trabajadores)) {
                //Imputar horas extra
                System.out.println("introduzca horas extra del trabajador: ");
                int horasExtraAImputar = scan.nextInt();
                scan.nextLine();
                
                //TODO: Encontrar trabajadador y guardar horas en el objeto
                Trabajador trabajadorAModificar = getTrabajadorByNombre(nombreTrabajador, trabajadores);
                trabajadorAModificar.setHoras(horasExtraAImputar);
                
                System.out.println("Horas extra imputadas con éxito.");
            } else {
                System.out.println("No existe el trabajador.");
            }
            
            System.out.println("introduzca nombre del trabajador: ");
            nombreTrabajador = scan.nextLine();
        }
    }

    public static void listWorkersOvertime(ArrayList<Trabajador> trabajadores, ArrayList<Categoria> categorias) {
        //TODO: listar trabajadores con nombre, categor'ia, horas extra  y total dinero ganado
        for (Trabajador t : trabajadores) {
            String nombre;
            String categoria;
            int horasExtraRealizadas;
            double totalDineroGanadoDeHorasExtra;
            
            Categoria categoriaDelTrabajador = getCategoriaByCodigo(t.getCategoria(), categorias);

            nombre = t.getNombre();
            categoria = categoriaDelTrabajador.getNombre();
            horasExtraRealizadas = t.getHoras();
            //calcular ganancia de horas extra
            totalDineroGanadoDeHorasExtra = categoriaDelTrabajador.getPrecioExtra() * horasExtraRealizadas;
            
            //TODO: si tuviésemos en cuenta las horas hábiles realizadas, tendríamos que calcular cuántas de las horas son extra.
            
            System.out.println("Nombre del trabajador: " + nombre + "\tCategoría: " + categoria + "\tHoras extra realizadas: "
                    + horasExtraRealizadas + "\tDinero total ganado: " + totalDineroGanadoDeHorasExtra);
        }
    }

    public static void showTotalCost(ArrayList<Trabajador> trabajadores, ArrayList<Categoria> categorias) {
        //TODO: mostrar coste total de los trabajadores para la empresa
        double costeTotal = 0;
        for(Trabajador t : trabajadores) {
            double costeDelTrabajador;
            int horasExtraRealizadas = t.getHoras();
            
            double precioDeHoraExtra = getCategoriaByCodigo(t.getCategoria() , categorias).getPrecioExtra();
            
            costeDelTrabajador = horasExtraRealizadas * precioDeHoraExtra;
            costeTotal += costeDelTrabajador;
        }
        
        System.out.println("Coste total de horas extras realizadas por trabajadores: " + costeTotal);
    }

    public static Categoria getCategoriaByCodigo(int codigo, ArrayList<Categoria> arr) {
        boolean encontrado = false;
        Categoria categoria = null;

        for (int i = 0; i < arr.size() && !encontrado; i++) {
            if (codigo == arr.get(i).getCodigo()) {
                encontrado = true;
                categoria = arr.get(i);
            }
        }
        return categoria;
    }
    
    public static boolean trabajadorExisteEnArrayList(String nombre, ArrayList<Trabajador> trabajadores) {
        boolean existe = false;
        for(int i = 0; i < trabajadores.size() && !existe;i++) {
            if(nombre.equalsIgnoreCase(trabajadores.get(i).getNombre())) {
                existe = true;
            }
        }
        return existe;
    }
    
    public static Trabajador getTrabajadorByNombre(String nombre, ArrayList<Trabajador> trabajadores) {
        boolean existe = false;
        Trabajador t = null;
        for(int i = 0; i < trabajadores.size() && !existe;i++) {
            if(nombre.equalsIgnoreCase(trabajadores.get(i).getNombre())) {
                existe = true;
                t = trabajadores.get(i);
            }
        }
        return t;
    }

}
