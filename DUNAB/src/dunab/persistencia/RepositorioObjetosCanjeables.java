package dunab.persistencia;

import dunab.modelo.ObjetoCanjeable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioObjetosCanjeables {
    private static final List<ObjetoCanjeable> objetos = List.of(
        new ObjetoCanjeable("Sombrero UNAB", "Sombrero de color", 10),
        new ObjetoCanjeable("Termo UNAB", "Termo de 2 Litros", 15),
        new ObjetoCanjeable("Camisa UNAB", "Camisa Senior", 30),
        new ObjetoCanjeable("Buzo UNAB", "Buzo cómodo", 50),  
        new ObjetoCanjeable("Cobija UNAB", "Perfecto para dormir en la biblioteca", 70),
        new ObjetoCanjeable("Chaqueta impermiable UNAB", "Chaqueta para lluvias", 90),
        new ObjetoCanjeable("Mochila Unab", "Mochila definitiva", 110)        
    );

    public static List<ObjetoCanjeable> getObjetos() {
        return objetos;
    }
}

