/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Datos {
    private String grupoRiesgo;
    private String edad;
    private String sexo;
    private String fechaVacunacion;
    private int dosis;
    private String fabricante;
    private String diresa;
    private String departamento;
    private String provincia;
    private String distrito;

    // Constructor
    public Datos(String grupoRiesgo, String edad, String sexo, String fechaVacunacion, 
                 int dosis, String fabricante, String diresa, 
                 String departamento, String provincia, String distrito) {
        this.grupoRiesgo = grupoRiesgo;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaVacunacion = fechaVacunacion;
        this.dosis = dosis;
        this.fabricante = fabricante;
        this.diresa = diresa;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    // Getters
    public String getGrupoRiesgo() {
        return grupoRiesgo;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaVacunacion() {
        return fechaVacunacion;
    }

    public int getDosis() {
        return dosis;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDiresa() {
        return diresa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "grupoRiesgo='" + grupoRiesgo + '\'' +
                ", edad='" + edad + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaVacunacion='" + fechaVacunacion + '\'' +
                ", dosis=" + dosis +
                ", fabricante='" + fabricante + '\'' +
                ", diresa='" + diresa + '\'' +
                ", departamento='" + departamento + '\'' +
                ", provincia='" + provincia + '\'' +
                ", distrito='" + distrito + '\'' +
                '}';
    }
}