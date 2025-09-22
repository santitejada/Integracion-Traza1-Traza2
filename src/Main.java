import Articulos.Articulo;
import Articulos.ArticuloInsumo;
import Articulos.ArticuloManufacturado;
import Entidades.*;
import Inventario.StockSucursal;
import Repositorios.InMemoryRepository;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Inicializar repositorios
        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();
        System.out.println("\n========== PRUEBAS DEL PROYECTO ANTERIOR ==========\n");

        //Creamos un pais "ARGENTINA"
        Pais argentina = Pais.builder().nombre("Argentina").
                build();

        // Creamos provincias y las relacionamos con el pais
        Provincia buenosAires = Provincia.builder()
                .id(1L)
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();

        // Creamos localidades y las relacionamos con la provincia
        Localidad caba = Localidad.builder()
                .id(1L)
                .nombre("CABA")
                .provincia(buenosAires)
                .build();
        // Creamos un domicilio y lo relacionamos con la localidad
        Domicilio domicilio1 = Domicilio.builder()
                .id(1L)
                .calle("Calle Corrientes")
                .numero(800)
                .cp(1008)
                .piso(2)
                .nroDpto(4)
                .localidad(caba)
                .build();

        Localidad laPlata = Localidad.builder()
                .id(2L)
                .nombre("La Plata")
                .provincia(buenosAires)
                .build();

        Domicilio domicilio2 = Domicilio.builder()
                .id(2L)
                .calle("Diag. 74")
                .numero(900)
                .cp(1902)
                .piso(1)
                .nroDpto(1)
                .localidad(laPlata)
                .build();


        Provincia cordoba = Provincia.builder()
                .id(2L)
                .nombre("Córdoba")
                .pais(argentina)
                .build();

        Localidad cordobaCapital = Localidad.builder()
                .id(3L)
                .nombre("Córdoba Capital")
                .provincia(cordoba)
                .build();

        Domicilio domicilio3 = Domicilio.builder()
                .id(3L)
                .calle("Av. Colon")
                .numero(300)
                .cp(5000)
                .piso(3)
                .nroDpto(3)
                .localidad(cordobaCapital)
                .build();


        Localidad villaCarlosPaz = Localidad.builder()
                .id(4L)
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();


        Domicilio domicilio4 = Domicilio.builder()
                .id(4L)
                .calle("Calle 4")
                .numero(400)
                .cp(4000)
                .piso(4)
                .nroDpto(4)
                .localidad(villaCarlosPaz)
                .build();

        // Creamos sucursales y las relacionamos con el domicilio
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio1)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(false)
                .domicilio(domicilio2)
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio3)
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(false)
                .domicilio(domicilio4)
                .build();

        // Creamos empresas y las asociamos a sucursales
        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("Razon Social 1")
                .cuit(12345678901L)
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .razonSocial("Razon Social 2")
                .cuit(22225678901L)
                .sucursales(new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();

        // Asignamos cada empresa a cada sucursal
        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        // Guardamos las empresas en el repositorio
        empresaRepository.save(empresa1);

        empresaRepository.save(empresa2);

        // Mostrar todas las empresas
        System.out.println("\nTodas las empresas:\n");
        List<Empresa> todasLasEmpresas = empresaRepository.findAll();
        todasLasEmpresas.forEach(System.out::println);

        // Buscar empresa por ID
        Optional<Empresa> empresaEncontrada = empresaRepository.findById(1L);
        empresaEncontrada.ifPresent(e -> System.out.println("\nEmpresa encontrada por ID 1: \n" + e));

        // Buscar empresa por nombre
        List<Empresa> empresasPorNombre = empresaRepository.genericFindByField("nombre", "Empresa 1");
        System.out.println("Empresas con nombre 'Empresa 1':");
        empresasPorNombre.forEach(System.out::println);

        // Actualizar empresa por ID
        Empresa empresaActualizada = Empresa.builder()
                .id(1L)
                .nombre("Empresa 1 Actualizada")
                .razonSocial("Razon Social 1 Actualizada")
                .cuit(12345678901L)
                .sucursales(empresa1.getSucursales())
                .build();

        empresaRepository.genericUpdate(1L, empresaActualizada);
        Optional<Empresa> empresaVerificada = empresaRepository.findById(1L);
        empresaVerificada.ifPresent(e -> System.out.println("Empresa después de la actualización: " + e));

        // Eliminar empresa por ID
        empresaRepository.genericDelete(1L);
        Optional<Empresa> empresaEliminada = empresaRepository.findById(1L);
        if (empresaEliminada.isEmpty()) {
            System.out.println("La empresa con ID 1 ha sido eliminada.");
        }

        // Mostrar todas las empresas restantes
        System.out.println("\nTodas las empresas después de la eliminación: ");
        List<Empresa> empresasRestantes = empresaRepository.findAll();
        empresasRestantes.forEach(System.out::println);
        System.out.println("\n--Mostrar las sucursales de una empresa determinada--\n");

        // Mostrar las sucursales de una empresa determinada
        Optional<Empresa> empresa = empresaRepository.findById(2L);
        if (empresa.isPresent()) {
            System.out.println("Sucursales de la empresa con ID " + ":");
            Set<Sucursal> sucursales = empresa.get().getSucursales();
            sucursales.forEach(System.out::println);
        } else {
            System.out.println("Empresa con ID " + " no encontrada.");
        }

//de aca para abajo es nuevo
        System.out.println("\n========== PRUEBAS DE STOCK POR SUCURSAL ==========\n");
    // Crear artículos e insumos
        ArticuloInsumo harina = new ArticuloInsumo("harina", 1.0, 100, 10, 200, true);
        ArticuloInsumo sal = new ArticuloInsumo("sal",0.5, 50, 5, 100, true);
        ArticuloInsumo cocaCola = new ArticuloInsumo("CocaCola", 5, 25, 100, 100, false);

        ArticuloManufacturado pizzaHawaiana = new ArticuloManufacturado("Pizza Hawaiana", 12.0);
        ArticuloManufacturado lomoCompleto = new ArticuloManufacturado("Lomo Completo", 15.0);


    // Cargar stock con precios distintos por sucursal
        sucursal1.agregarStock(pizzaHawaiana, 10, 20.0);
        sucursal1.agregarStock(lomoCompleto, 5, 25.0);
        sucursal1.agregarStock(cocaCola, 12, 10.0);

        sucursal2.agregarStock(pizzaHawaiana, 3, 22.0);
        sucursal2.agregarStock(lomoCompleto, 8, 27.0);
        sucursal2.agregarStock(cocaCola, 5, 10.0);

        sucursal3.agregarStock(pizzaHawaiana, 7, 23.5);
        sucursal3.agregarStock(lomoCompleto, 10, 28.0);
        sucursal3.agregarStock(cocaCola, 20, 14.0);

        sucursal4.agregarStock(pizzaHawaiana, 0, 21.0);
        sucursal4.agregarStock(lomoCompleto, 2, 26.0);
        sucursal4.agregarStock(cocaCola, 8, 14.0);

// Mostrar stock de todas las empresas
        System.out.println(empresa1.mostrarStockEmpresa());
        System.out.println(empresa2.mostrarStockEmpresa());
    }

    }