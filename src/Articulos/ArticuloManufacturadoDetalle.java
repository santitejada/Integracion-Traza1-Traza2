package Articulos;


import lombok.*;
import lombok.experimental.SuperBuilder;

//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@SuperBuilder
public class ArticuloManufacturadoDetalle {

    private Long id;
    private Integer cantidad;


    private Articulos.ArticuloInsumo articuloInsumo;
}
