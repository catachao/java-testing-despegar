
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BusquedaActividadTest {
    private BusquedaActividad busqueda;

    @BeforeEach
    void setUp() {
        busqueda = new BusquedaActividad();
    }

    @Test
    void testBusquedaValida() {
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        List<Actividad> resultados = busqueda.buscar("Madrid", fechaInicio, fechaFin);
        assertFalse(resultados.isEmpty());
        assertEquals("Madrid", resultados.get(0).getDestino());
    }

    @Test
    void testBusquedaDestinoVacio() {
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        assertThrows(IllegalArgumentException.class, () -> {
            busqueda.buscar("", fechaInicio, fechaFin);
        });
    }

    @Test
    void testBusquedaFechasInvalidas() {
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.minusDays(1);
        assertThrows(IllegalArgumentException.class, () -> {
            busqueda.buscar("Madrid", fechaInicio, fechaFin);
        });
    }

    @Test
    void testBusquedaDestinoInexistente() {
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        List<Actividad> resultados = busqueda.buscar("París", fechaInicio, fechaFin);
        assertTrue(resultados.isEmpty());
    }
}

