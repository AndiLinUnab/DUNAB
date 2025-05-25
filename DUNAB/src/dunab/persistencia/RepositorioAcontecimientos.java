package dunab.persistencia;

import dunab.modelo.Acontecimiento;

import java.time.LocalDate;
import java.util.*;

public class RepositorioAcontecimientos {
    private static List<Acontecimiento> acontecimientos = new ArrayList<>();

    static {
        acontecimientos.add(new Acontecimiento(1, "Feria de Proyectos", "Exposición de trabajos estudiantiles", LocalDate.now().plusDays(10), "Auditorio Central", 5));
        acontecimientos.add(new Acontecimiento(2, "Hackathon UNAB", "Competencia de programación", LocalDate.now().plusDays(20), "Sala Innovación", 10));
        acontecimientos.add(new Acontecimiento(3, "Charla de Liderazgo", "Conferencista invitado", LocalDate.now().plusDays(5), "Aula Magna", 3));
    }

    public static List<Acontecimiento> obtenerTodos() {
        return new ArrayList<>(acontecimientos);
    }

    public static Acontecimiento buscarPorId(int id) {
        return acontecimientos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }
}
