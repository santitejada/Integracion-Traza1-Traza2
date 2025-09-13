package Entidades;

import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "empresa") // excluir empresa para evitar recursion infinita
@Builder

public class Sucursal {
    private String nombre;
    private Long id;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    private Domicilio domicilio;
    private Empresa empresa;


    public void setEmpresa(Empresa empresa) {
    }
}
