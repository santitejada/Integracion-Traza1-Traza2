package Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

//import javax.persistence.Entity;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder


public class Articulo  {
    protected Long id;
    protected String denominacion;
    protected double precioVenta;



    @Builder.Default

    protected Set<ImagenArticulo> imagenes = new HashSet<>();


    protected UnidadMedida unidadMedida;


    private Categoria categoria;


    public Articulo(String denominacion, double precioVenta) {
    this.denominacion = denominacion;
    this.precioVenta = precioVenta;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    @Override
    public String toString() {
       return denominacion + " ($" + precioVenta + ")";
    }

    public String getNombre() {
   return denominacion;
    }
}

