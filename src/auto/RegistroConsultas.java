/***  Objetivo:  El objetivo de esta clase es el de crear los desceuntos e impuestos(en los metodos obtener total
 * cuenta,descontar y obtenerTotalFinal)
 ***@version    V1.0 2/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */
package auto;

import model.Auto;
import static auto.Calculo.IVA;
import static auto.Calculo.SEGURO;
import java.util.Random;

public class RegistroConsultas implements Calculo
{
    private Auto auto;
    private int lujo;
    private byte seguro;
    private double totalInicial;
    private double totalIVA;
    private double totalSeguro;
    private double totalLujo;
    private double totalFinal;
        
    public int Aleatorio(int min, int max) {
        Random ran = new Random();
        int x = ran.nextInt(max) + min;
        return x;
    }
    
    public RegistroConsultas(Auto auto, byte seguro, int lujo)
    {
        this.auto = auto;
        this.seguro = seguro;
        this.lujo = lujo;
    }
    public Auto getAuto() { return auto; }
    public int getSeguro() { return seguro; }
    public int getLujo() { return lujo; }
    public double getTotalInicial() { return totalInicial; }
    public double getTotalIVA() { return totalIVA; }
    public double getTotalSeguro() { return totalSeguro; }
    public double getTotalLujo() { return totalLujo; }
    public double getTotalFinal() { return totalFinal; }
    
    public void calcularPrecio(){
        totalInicial = Aleatorio(1000000,15000000);
        totalIVA = totalInicial * IVA;
        totalSeguro = ( getSeguro() == 1 ) ? totalIVA*SEGURO:0;
        totalLujo = totalSeguro * getLujo();
        totalFinal = totalLujo;
    }
}
