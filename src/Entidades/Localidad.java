package Entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (exclude = "domicilios")
@Builder

public class Localidad {
    private String nombre;
    private Provincia provincia;
    private Long id;

    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();


}