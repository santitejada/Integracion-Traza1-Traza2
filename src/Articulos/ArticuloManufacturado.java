package Articulos;


import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@SuperBuilder
public class ArticuloManufacturado  extends Articulos.Articulo {

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;



    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();

    public ArticuloManufacturado(String denominacion, double precioVenta) {
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
    }

}
