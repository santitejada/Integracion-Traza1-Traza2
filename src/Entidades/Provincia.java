package Entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"pais","localidades"}) // excluimos pais y localidades para evitar recursion infinita
@Builder

public class Provincia {
    private String nombre;
    private Long id;
    private Pais pais;

    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();

    @Override
    public String toString() {
        return "Provincia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais=" + (pais != null ? pais.getNombre() : null) + // Evitar recursión infinita
                '}';
    }

}
