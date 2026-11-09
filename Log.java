package ListaCrs;

import javax.swing.*;
import java.util.ArrayList;

public class Log {

    public ArrayList<String> registrarProfes() {
        ArrayList<String> profesores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String prof;
            do {
                prof = JOptionPane.showInputDialog("Ingrese el nombre del profesor " + (i + 1));
                if (profesores.contains(prof)) {
                    JOptionPane.showMessageDialog(null, "Ese profesor ya existe." +
                            " Ingrese un nombre diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (profesores.contains(prof));

            profesores.add(prof);
        }
        return profesores;
    }

    public ArrayList<String> registrarAlumnos(ArrayList<String> profesores) {
        ArrayList<String> alumnos = new ArrayList<>();
        ArrayList<String> nombresValidador = new ArrayList<>();
        String[] opciones = profesores.toArray(new String[0]);

        for (int i = 0; i < 5; i++) {
            String alumno;
            do {
                alumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno " + (i + 1));
                if (nombresValidador.contains(alumno)) {
                    JOptionPane.showMessageDialog(null, "Ese alumno ya existe." +
                            " Ingrese un nombre diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (nombresValidador.contains(alumno));
            nombresValidador.add(alumno);
            String profesor = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione un profesor para el alumno " + alumno,
                    "Profesores",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            alumnos.add(alumno + " - Profesor: " + profesor);
        }
        return alumnos;
    }


    public void mostrarProfesAlums(ArrayList<String> profesores, ArrayList<String> alumnos) {

        StringBuilder sb = new StringBuilder();
        for (String profesor : profesores) {
            sb.append(profesor).append(" tiene los siguientes alumnos:\n");
            for (String alumno : alumnos) {
                if (alumno.contains(" - Profesor: " + profesor)) {
                    sb.append("- ").append(alumno.split(" - Profesor: ")[0]).append("\n");
                }
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(),
                "Lista de Profesores y sus alumnos",
                JOptionPane.INFORMATION_MESSAGE);
    }



    public void consultarProfesor(ArrayList<String> profesores, ArrayList<String> alumnos) {
        String[] opciones = profesores.toArray(new String[0]);
        String profesor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione un profesor para consultar",
                "Profesores",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún profesor.",
                    "Consulta de profesores", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int cantidad = 0;
        for (String alumno : alumnos) {
            if (alumno.contains(" - Profesor: " + profesor)) {
                String nombreAlumno = alumno.split(" - Profesor: ")[0];
                sb.append("- ").append(nombreAlumno).append("\n");
                cantidad++;
            }
        }
        sb.insert(0, "Profesor: " + profesor + "\n\n");
        sb.append("\nTotal de alumnos: ").append(cantidad);
        JOptionPane.showMessageDialog(null, sb.toString(),
                "Consulta de profesores",
                JOptionPane.INFORMATION_MESSAGE);
    }




    public void alumnosProf( ArrayList<String> alumnos){

        StringBuilder sb = new StringBuilder();
        String[] opciones = new String[alumnos.size()];
        for(int i = 0; i < alumnos.size(); i++){
            opciones[i] = alumnos.get(i).split(" - Profesor: ")[0];
        }
        String alumno = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione un alumno para consultar",
                "Alumnos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        if(alumno == null){
            return;
        }
        for(String registro : alumnos){
            String[] datos = registro.split(" - Profesor: ");
            if(datos[0].equals(alumno)){
                sb.append("Alumno: ").append(datos[0]).append("\n");
                sb.append("Profesor asignado: ").append(datos[1]);

                break;
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString(),
                "Consulta de Alumnos y sus profesores",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
