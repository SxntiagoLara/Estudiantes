package Taller1;

import javax.swing.JOptionPane;

public class Estudiantes  {
    protected static String[] nombres = new String[50];
    protected static int[] edades = new int[50];
    protected static int numeroEstudiantes = 0;
    public static void main(String[] args) {
        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    imprimirListaEstudiantes();
                    break;
                case 3:
                    PromedioEdades();
                    break;
                case 4:
                    encontrarMayoresEdad();
                    break;
                case 5:
                    encontrarMenoresEdad();
                    break;
                case 6:
                    contarMayoresEdad();
                    break;
                case 7:
                    buscarPorNombre();
                    break;
                case 8:
                    buscarPorEdad();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 9);
    }
    private static int mostrarMenu() {
        String menu = "Seleccione una opción:\n\n";
        		menu +=  "1. Agregar estudiante\n";
        		menu += "2. Imprimir lista de estudiantes\n";
        		menu += "3. Calcular promedio de edades\n";
        		menu += "4. Encontrar estudiantes de mayor edad\n";
        		menu += "5. Encontrar estudiantes de menor edad\n";
        		menu += "6. Contar estudiantes mayores de edad\n";
        		menu += "7. Buscar estudiante por nombre\n";
        		menu += "8. Buscar estudiantes por edad\n";
        		menu += "9. Salir";
        String opcion = JOptionPane.showInputDialog(null, menu);
        return Integer.parseInt(opcion);
    }
    private static void agregarEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad:"));
        nombres[numeroEstudiantes] = nombre;
        edades[numeroEstudiantes] = edad;
        numeroEstudiantes++;
    }
    private static void imprimirListaEstudiantes() {
        String lista = "La lista es:\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            lista += nombres[i] + " con " + edades[i] + " años \n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    private static void PromedioEdades() {
        int sumaEdades = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            sumaEdades += edades[i];
        }
        double promedio = (double) sumaEdades / numeroEstudiantes;
        JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
    }
    private static void encontrarMayoresEdad() {
        int maxEdad = Integer.MIN_VALUE;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] > maxEdad) {
                maxEdad = edades[i];
            }
        }
        String estudiantes = "Estudiantes de mayor edad:\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == maxEdad) {
                estudiantes += nombres[i] + " - " + edades[i            ] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }
    private static void encontrarMenoresEdad() {
        int minEdad = Integer.MAX_VALUE;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] < minEdad) {
                minEdad = edades[i];
            }
        }
        String estudiantes = "Estudiantes de menor edad:\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == minEdad) {
                estudiantes += nombres[i] + " - " + edades[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }
    private static void contarMayoresEdad() {
        int contador = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] >= 18) {
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Hay " + contador + " estudiantes mayores de edad.");
    }
    private static void buscarPorNombre() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:");
        int j = -1;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró con ese nombre");
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante encontrado es: " + nombres[j] + " - " + edades[j]);
        }
    }
    private static void buscarPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad a buscar:"));
        String estudiantes = "lista por edad " + edad + ":\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == edad) {
                estudiantes += nombres[i] + " - " + edades[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }
}