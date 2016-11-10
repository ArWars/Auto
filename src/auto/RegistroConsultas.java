/***  Objetivo:  El objetivo de esta clase es el de crear los desceuntos e impuestos(en los metodos obtener total
 * cuenta,descontar y obtenerTotalFinal)
 ***@version    V1.0 2/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */
package auto;

import model.Auto;
import static auto.Calculo.DESCUENTO_PERRO;
import static auto.Calculo.DESCUENTO_PEZ;
import static auto.Calculo.IVA;

public class RegistroConsultas implements Calculo
{
    private Auto auto;
    private int chequeo;
    private int remedios;
    private int procedimiento;
    private double totalCuenta;
    private double descuento;
    private double totalFinal;
    private double totallol;
        
    public RegistroConsultas(Auto auto, int chequeo, int remedios, int procedimiento)
    {
        this.auto = mascota;
        this.chequeo = chequeo;
        this.remedios = remedios;
        this.procedimiento= procedimiento;
    }
    public Auto getMascota() { return mascota; }
    public int getChequeo() { return chequeo; }
    public int getRemedios() { return remedios; }
    public int getProcedimiento() { return procedimiento; }
    public double getTotalCuenta() { return totalCuenta; }
    public double getDescuento() { return descuento; }
    public double getTotalFinal() { return totalFinal; }
    
    public void obtenerTotalCuenta(){
        totalCuenta = chequeo + remedios + procedimiento;
        totalCuenta=totalCuenta+(totalCuenta*IVA);
    }
    public void descontar()
    {
        if ( mascota instanceof Susuki ) descuento=totalCuenta*DESCUENTO_PERRO;
        else descuento = totalCuenta*DESCUENTO_PEZ;
    }
    public void obtenerTotalFinal() { totalFinal = totalCuenta-descuento; }
}
