public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();

        Perro perro1 = new Perro("Luca", 5, "Labrador");
        Gato gato1 = new Gato("Miau", 3);

        zoologico.agregarAnimal(perro1);
        zoologico.agregarAnimal(gato1);
        Perro perro2 = new Perro("Ilona", 5, "Labrador");
        Gato gato2 = new Gato("Miau", 3);

        zoologico.agregarAnimal(perro2);
        zoologico.agregarAnimal(gato2);

        // Guardar la lista de animales en un archivo binario
        zoologico.guardarAnimalesEnArchivo("animales.bin");

        // Mostrar los sonidos de los animales y su conteo
        zoologico.mostrarSonido();
        zoologico.mostrarConteoAnimales();

        // Cargar la lista de animales desde el archivo binario
        zoologico.cargarAnimalesDesdeArchivo("animales.bin");

        // Verificar que los animales se cargaron correctamente
        zoologico.mostrarSonido();
    }
}

