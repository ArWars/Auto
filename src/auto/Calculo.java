/***  Objetivo:  El objetivo de esta interface es el de almacenar los valores del IVA y
 * los descuentos para PEZ y PERRO, aparte de almacenar los metodos obatenerTotalCuenta,
 * descontar y obtenerTotalFinal
 ***@version v1.0    02/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */
package auto;

/**
 *
 * @author AriieelEsteban
 */

public interface Calculo
{
    final double IVA = 0.19;
    final double DESCUENTO_PERRO = 0.1;
    final double DESCUENTO_PEZ = 0.2;
    
    public void obtenerTotalCuenta();
    public void descontar();
    public void obtenerTotalFinal();
}
