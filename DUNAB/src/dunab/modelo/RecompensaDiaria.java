package dunab.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class RecompensaDiaria implements Serializable {
    private LocalDate ultimaRecompensa;
    private int racha;

    public RecompensaDiaria() {
        this.ultimaRecompensa = LocalDate.MIN;
        this.racha = 0;
    }

    public LocalDate getUltimaRecompensa() {
        return ultimaRecompensa;
    }

    public void setUltimaRecompensa(LocalDate ultimaRecompensa) {
        this.ultimaRecompensa = ultimaRecompensa;
    }

    public int getRacha() {
        return racha;
    }

    public void incrementarRacha() {
        racha++;
    }

    public void reiniciarRacha() {
        racha = 1;
    }
}


