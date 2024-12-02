import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusquedaActividad {
    private List<Actividad> actividades;

    public BusquedaActividad() {
        this.actividades = new ArrayList<>();
        // Inicializamos algunas actividades de ejemplo
        actividades.add(new Actividad("Tour por la ciudad", "Madrid", 50.0));
        actividades.add(new Actividad("Excursión a la montaña", "Sierra Nevada", 80.0));
        actividades.add(new Actividad("Visita al museo", "Barcelona", 15.0));
    }

    public List<Actividad> buscar(String destino, LocalDate fechaInicio, LocalDate fechaFin) {
        if (destino == null || destino.trim().isEmpty() || fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Los parámetros de búsqueda no pueden estar vacíos");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin");
        }

        List<Actividad> resultados = new ArrayList<>();
        for (Actividad actividad : actividades) {
            if (actividad.getDestino().equalsIgnoreCase(destino)) {
                resultados.add(actividad);
            }
        }
        return resultados;
    }
}

class Actividad {
    private String nombre;
    private String destino;
    private double precio;

    public Actividad(String nombre, String destino, double precio) {
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDestino() { return destino; }
    public double getPrecio() { return precio; }
}

