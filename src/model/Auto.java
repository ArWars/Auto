/***  Objetivo:  El objetivo de esta clase es los constructores(con y sin parametros),
 * los gets y sets,el toString y el metodo abstracto descripcion; ademas funciona como clase padre para
 * Pez y Perro.
 ***@version    V1.0 2/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */
package model;

/**
 *
 * @author AriieelEsteban
 */
public class Auto {
    private int    id;
    private String modelo, anio, foto;
    private byte   papeles, puertas, llantas;

    public Auto(){
    }
    
    public Auto(int id, String modelo, String anio, String foto, byte papeles, byte puertas, byte llantas, int lujo) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
        this.foto = foto;
        this.papeles = papeles;
        this.puertas = puertas;
        this.llantas = llantas;
    }

    // LISTADO DE SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPapeles(byte papeles) {
        this.papeles = papeles;
    }

    public void setPuertas(byte puertas) {
        this.puertas = puertas;
    }

    public void setLlantas(byte llantas) {
        this.llantas = llantas;
    }

    // LISTADO DE GETTERS
    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnio() {
        return anio;
    }

    public String getFoto() {
        return foto;
    }

    public byte getPapeles() {
        return papeles;
    }

    public byte getPuertas() {
        return puertas;
    }

    public byte getLlantas() {
        return llantas;
    }

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", modelo=" + modelo + ", anio=" + anio + ", foto=" + foto + ", papeles=" + papeles + ", puertas=" + puertas + ", llantas=" + llantas + '}';
    }

    
    
    
}