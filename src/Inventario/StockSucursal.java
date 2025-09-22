package Inventario;

import Articulos.Articulo;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class StockSucursal {
    private Articulo articulo;  // Puede ser un ArticuloInsumo o ArticuloManufacturado
    private int cantidad;
    private double precioVenta;


    public StockSucursal(Articulo articulo, int cantidad) {
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo no puede ser null");
        }
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return articulo.getNombre() +
                " -> " + cantidad + " unidades, " +
                "valor unitario: $" + precioVenta;
    }
}
