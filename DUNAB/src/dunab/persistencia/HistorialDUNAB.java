package dunab.persistencia;

import dunab.modelo.MovimientoDUNAB;
import dunab.modelo.Usuario;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;

public class HistorialDUNAB {
    private static Map<Integer, List<MovimientoDUNAB>> historial = new HashMap<>();

    public static void registrarMovimiento(Usuario usuario, double cantidad) {
        historial.putIfAbsent(usuario.getId(), new ArrayList<>());
        historial.get(usuario.getId()).add(new MovimientoDUNAB(LocalDate.now(), cantidad));
    }

    public static double calcularPromedio(Usuario usuario, String periodo) {
        List<MovimientoDUNAB> movimientos = historial.getOrDefault(usuario.getId(), new ArrayList<>());
        LocalDate hoy = LocalDate.now();

        return movimientos.stream()
                .filter(m -> filtrarPorPeriodo(m.getFecha(), hoy, periodo))
                .mapToDouble(MovimientoDUNAB::getCantidad)
                .average()
                .orElse(0.0);
    }

    private static boolean filtrarPorPeriodo(LocalDate fecha, LocalDate hoy, String periodo) {
        switch (periodo.toLowerCase()) {
            case "semana":
                return fecha.get(WeekFields.ISO.weekOfWeekBasedYear()) == hoy.get(WeekFields.ISO.weekOfWeekBasedYear()) && fecha.getYear() == hoy.getYear();
            case "mes":
                return fecha.getMonth() == hoy.getMonth() && fecha.getYear() == hoy.getYear();
            case "semestre":
                int semestreActual = hoy.getMonthValue() <= 6 ? 1 : 2;
                int semestreFecha = fecha.getMonthValue() <= 6 ? 1 : 2;
                return semestreActual == semestreFecha && fecha.getYear() == hoy.getYear();
            case "año":
                return fecha.getYear() == hoy.getYear();
            default:
                return false;
        }
    }
}