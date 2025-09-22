package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "sucursales") // excluimos sucursales para evitar recursion infinita
@SuperBuilder
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Long cuit;

    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    public String mostrarStockEmpresa() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stock de ").append(this.getNombre()).append(":\n");
        for (Sucursal suc : sucursales) {
            sb.append(suc.mostrarStock());
        }
        return sb.toString();
    }


}
