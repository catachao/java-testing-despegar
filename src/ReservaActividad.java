import java.time.LocalDate;

public class ReservaActividad {
    private Actividad actividad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String nombreUsuario;

    public ReservaActividad(Actividad actividad, LocalDate fechaInicio, LocalDate fechaFin, String nombreUsuario) {
        this.actividad = actividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreUsuario = nombreUsuario;
    }

    public boolean verificarDisponibilidad() {
        // Simulamos la verificación de disponibilidad
        return true;
    }

    public double calcularPrecioTotal() {
        int dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay() + 1);
        double precioBase = actividad.getPrecio() * dias;
        double impuestos = precioBase * 0.21; // 21% de impuestos
        return precioBase + impuestos;
    }

    public String generarConfirmacion() {
        if (!verificarDisponibilidad()) {
            throw new RuntimeException("La actividad no está disponible para las fechas seleccionadas");
        }
        return String.format("Reserva confirmada para %s\nActividad: %s\nDestino: %s\nFecha: %s - %s\nPrecio total: %.2f€",
                nombreUsuario, actividad.getNombre(), actividad.getDestino(),
                fechaInicio, fechaFin, calcularPrecioTotal());
    }

    public boolean procesarPago(String numeroTarjeta) {
        // Simulamos el procesamiento del pago
        return !numeroTarjeta.equals("1111111111111111"); // Tarjeta denegada para este número
    }
}

