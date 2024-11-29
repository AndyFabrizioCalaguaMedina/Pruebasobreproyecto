/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import Modelo.Usuario;
import Modelo.Errores;
import Controlador.ControladorErrores;

public class SistemaReporte {
    private Usuario usuario;
    private int intentos = 0;

    // Constructor inicializa el usuario
    public SistemaReporte() {
        this.usuario = new Usuario("", "");
    }

    public void imprimirBienvenidaLogin() {
        System.out.println("====================================");
        System.out.println("BIENVENIDO, INGRESE SUS CREDENCIALES");
        System.out.println("====================================");
    }

    public void accesoSistema() {
        Scanner scanner = new Scanner(System.in);
        while (intentos < 5) {
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            usuario.setNombreUsuario(nombreUsuario);
            usuario.setContrasena(contrasena);

            if (validarUsuario()) {
                System.out.println("¡BIENVENIDO, " + nombreUsuario + "!");
                mostrarMenuPrincipal();
                return;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + " de 5.");
            }
        }
        if (intentos >= 5) {
            System.out.println("Número de intentos excedido. El programa se cerrará.");
        }
    }

    private boolean validarUsuario() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals(usuario.getNombreUsuario()) && partes[1].equals(usuario.getContrasena())) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
            Errores error = new Errores(e.getMessage(), "Error", LocalDate.now().toString(), LocalTime.now().toString(), usuario.getNombreUsuario());
            ControladorErrores.guardarError(error);
            return false;
        }
    }

    private void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("                     MENU PRINCIPAL                     ");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Perfil de Vacunación");
            System.out.println("2. Cobertura Demográfica");
            System.out.println("3. Avance Geográfico");
            System.out.println("4. Reporte de Dosis Aplicadas");
            System.out.println("0. FIN DEL PROGRAMA");
            System.out.println("--------------------------------------------------------");
            System.out.print("Ingrese opción [1 – 4]: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Mostrar reporte de perfil de vacunación...");
                        break;
                    case 2:
                        System.out.println("Mostrar reporte de cobertura demográfica...");
                        break;
                    case 3:
                        System.out.println("Mostrar reporte de avance geográfico...");
                        break;
                    case 4:
                        System.out.println("Mostrar reporte de dosis aplicadas...");
                        break;
                    case 0:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, ingrese un número entre 0 y 4.");
                Errores error = new Errores("Entrada no válida en el menú principal", "Error", LocalDate.now().toString(), LocalTime.now().toString(), usuario.getNombreUsuario());
                ControladorErrores.guardarError(error);
            }
        } while (opcion != 0);
    }
}
