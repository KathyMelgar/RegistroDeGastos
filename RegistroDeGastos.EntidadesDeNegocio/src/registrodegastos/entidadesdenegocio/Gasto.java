
package registrodegastos.entidadesdenegocio;

import java.time.LocalDate;


public class Gasto {
    private int id;
    private int idCategoria;
    private int idUsuario;
    private double monto;
    private LocalDate fecha;
    private String descripcion;
    private int top_aux;
    private Categoria categoria;
    private Usuario usuario;

    public Gasto() {
    }

    public Gasto(int id, int idCategoria, int idUsuario, double monto, LocalDate fecha, String descripcion, int top_aux, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.top_aux = top_aux;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
