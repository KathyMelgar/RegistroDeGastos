
package registrodegastos.entidadesdenegocio;


import java.util.ArrayList;

public class Categoria {
    private int id;
    private String nombre;
    private int top_aux;
    private ArrayList<Gasto> gastos;

    public Categoria() {
    }

    public Categoria(int id, String nombre, int top_aux, ArrayList<Gasto> gastos) {
        this.id = id;
        this.nombre = nombre;
        this.top_aux = top_aux;
        this.gastos = gastos;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public ArrayList<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(ArrayList<Gasto> gastos) {
        this.gastos = gastos;
    }



    

   

    
    
   
}
