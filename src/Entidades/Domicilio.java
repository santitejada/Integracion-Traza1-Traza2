package Entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "localidad") // excluimos localidad para evitar recursion infinita
@Builder

public class Domicilio {
   private String calle;
   private Integer numero;
   private Integer cp;
   private Long id;
   private Integer piso;
   private Integer nroDpto;

   private Localidad localidad;

   //private Sucursal sucursal;

}
