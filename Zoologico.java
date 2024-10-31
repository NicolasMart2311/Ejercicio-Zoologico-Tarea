import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoologico {
    private List<Animal> animales;
    private Map<String, Integer> conteoPortipo;

    public Zoologico() {
        animales = new ArrayList<>();
        conteoPortipo = new HashMap<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarSonido() {
        for (Animal animal : animales) {
            System.out.println("Nombre: " + animal.getNombre() + 
                               ", Edad: " + animal.getEdad() + 
                               ", Sonido: " + animal.hacerSonido() +
                               ", Nombre en mayúsculas: " + animal.getNombreEnMayusculas());
        }
    }

    public void mostrarConteoAnimales() {
        for (Animal animal : animales) {
            String tipo = animal.getClass().getSimpleName();
            conteoPortipo.put(tipo, conteoPortipo.getOrDefault(tipo, 0) + 1);
        }
        for (String tipo : conteoPortipo.keySet()) {
            System.out.println("Tipo: " + tipo + ", cantidad: " + conteoPortipo.get(tipo));
        }
    }

    public void guardarAnimalesEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(animales);
            System.out.println("Lista de animales guardada en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de animales: " + e.getMessage());
        }
    }

    public void cargarAnimalesDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            animales = (List<Animal>) ois.readObject();
            System.out.println("Lista de animales cargada desde el archivo " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la lista de animales: " + e.getMessage());
        }
    }
}
