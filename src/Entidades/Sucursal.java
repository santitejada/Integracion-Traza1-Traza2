package Entidades;

import Articulos.Articulo;
import Articulos.ArticuloInsumo;
import Articulos.ArticuloManufacturado;
import Inventario.StockSucursal;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "empresa")
@Builder
public class Sucursal {
    private String nombre;
    private Long id;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;
    private Domicilio domicilio;
    private Empresa empresa;

    @Builder.Default
    private Set<ArticuloManufacturado> articulos = new HashSet<>();

    @Builder.Default
    private Set<ArticuloInsumo> insumos = new HashSet<>();

    // Lista de stock inicializada para evitar NullPointerException
    @Builder.Default
    private List<StockSucursal> stock = new ArrayList<>();

    // Métodos de negocio
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void agregarArticulo(ArticuloManufacturado articulo) {
        articulos.add(articulo);
    }

    public void agregarInsumo(ArticuloInsumo insumo) {
        insumos.add(insumo);
    }


    public void agregarStock(Articulo articulo, int cantidad, double precio) {
        stock.add(new StockSucursal(articulo, cantidad, precio));
    }

    public String mostrarStock() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ").append(this.getNombre()).append(":\n");
        if (stock.isEmpty()) {
            sb.append("    (sin stock cargado)\n");
        } else {
            for (StockSucursal s : stock) {
                sb.append("    ").append(s).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Sucursal: " + nombre + ", Stock: " + stock;
    }
}

