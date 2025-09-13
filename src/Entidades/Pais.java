package Entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (exclude = "provincias") // excluimos provincia para evitar recursion infinita
@Builder

public class Pais {
    private String nombre;
    private Long id;

    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();


    @Override
    public String toString() {
        return null;
    }

}
