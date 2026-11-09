
package ListaCrs;

import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    public void menu() {

        Log log = new Log();

        ArrayList<String> profesores = new ArrayList<>();
        ArrayList<String> alumnos = new ArrayList<>();

        String opciones[] = {
                "1- Registrar profesores y alumnos",
                "2- Mostrar profesores y alumnos",
                "3- Consultar profesor",
                "4- Alumnos por profesor",
                "5- Salir"
        };

        Object seleccion;

        do {
            seleccion = JOptionPane.showInputDialog(
                    null, "Selecciona una opción:", "Menú",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]
            );
            if (seleccion == null || seleccion.toString().equals("5- Salir")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                break;
            }
            switch (seleccion.toString()) {
                case "1- Registrar profesores y alumnos":
                    profesores = log.registrarProfes();
                    alumnos = log.registrarAlumnos(profesores);
                    break;
                case "2- Mostrar profesores y alumnos":
                    if (profesores.isEmpty() || alumnos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar profesores y alumnos.");
                    } else {
                        log.mostrarProfesAlums(profesores, alumnos);
                    }
                    break;
                case "3- Consultar profesor":
                    if (profesores.isEmpty() || alumnos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar profesores y alumnos.");
                    } else {
                        log.consultarProfesor(profesores, alumnos);
                    }
                    break;
                case "4- Alumnos por profesor":
                    if (profesores.isEmpty() || alumnos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar profesores y alumnos.");
                    } else {
                        log.alumnosProf( alumnos);
                    }

                    break;
            }
        } while (true);
    }
}
