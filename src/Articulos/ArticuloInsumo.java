package Articulos;


import lombok.*;
import lombok.experimental.SuperBuilder;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder

public class ArticuloInsumo extends Articulos.Articulo {
    private String denominacion;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    public ArticuloInsumo(String denominacion, double precioCompra, int stockActual, int stockMinimo, int stockMaximo, boolean esParaElaborar) {

        super(denominacion, precioCompra);
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.esParaElaborar = esParaElaborar;
    }
}
