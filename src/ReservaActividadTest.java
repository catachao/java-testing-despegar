import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaActividadTest {
    private ReservaActividad reserva;
    private Actividad actividad;

    @BeforeEach
    void setUp() {
        actividad = new Actividad("Tour por la ciudad", "Madrid", 50.0);
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(2);
        reserva = new ReservaActividad(actividad, fechaInicio, fechaFin, "Juan Pérez");
    }

    @Test
    void testVerificarDisponibilidad() {
        assertTrue(reserva.verificarDisponibilidad());
    }

    @Test
    void testCalcularPrecioTotal() {
        double precioEsperado = (50.0 * 3) * 1.21; // 3 días con 21% de impuestos
        assertEquals(precioEsperado, reserva.calcularPrecioTotal(), 0.01);
    }

    @Test
    void testGenerarConfirmacion() {
        String confirmacion = reserva.generarConfirmacion();
        assertTrue(confirmacion.contains("Juan Pérez"));
        assertTrue(confirmacion.contains("Tour por la ciudad"));
        assertTrue(confirmacion.contains("Madrid"));
    }

    @Test
    void testProcesarPagoExitoso() {
        assertTrue(reserva.procesarPago("4111111111111111"));
    }

    @Test
    void testProcesarPagoDenegado() {
        assertFalse(reserva.procesarPago("1111111111111111"));
    }
}

