/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

public class main {
    public static void main(String[] args) {
        // Crear una instancia de SistemaReporte
        SistemaReporte sistema = new SistemaReporte();

        // Imprimir bienvenida e iniciar el proceso de acceso al sistema
        sistema.imprimirBienvenidaLogin();

        // Llamar al método de acceso al sistema
        sistema.accesoSistema();
    }
}
