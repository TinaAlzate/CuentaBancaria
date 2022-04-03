

package cuentabancaria;

import java.util.Date;
 /**
  * cuenta sirve para crear cuentas, retornar y modificar valores.
  * @author Valentina Alzate
  */
public class cuenta
{    
   private int edadcliente;
   private Date fechadecreacion;
   private String nombredelcliente;
   private String numerodecuenta;
   private double saldo;
   private final double saldominimo = 0;
  /**
   * Este es el construtor de la cuenta.
   * @param fechadecreacion fecha en que se da de alta un cliente
   * @param nombredelcliente el nombre al que estara la cuenta
   * @param numerodecuenta numero de la cuenta del cliente
   * @param saldo el dinero que tiene el cliente al momento de crear la cuenta (el cual al principio por lo general es 0)
   */
    public cuenta(Date fechadecreacion, String nombredelcliente,String numerodecuenta, double saldo)
    {
      this.fechadecreacion = fechadecreacion;
      this.nombredelcliente = nombredelcliente;
      this.numerodecuenta = numerodecuenta;
      this.saldo = saldo; 
      edadcliente = 52;
    }
    /**
     * Edad cliente
     * @return Este "get" retorna la edad del cliente
     */
    public int getedadcliente()
    {
        return edadcliente;
    }
    /**
     * Fecha creación
     * @return este metodo "get" devuelve la fecha de la creacion de la cuenta
     */
  public Date getfechadecreacion()
  {
    return fechadecreacion;
  }
  /**
   * Nombre cliente
   * @return "get" que devuelve el nombre del cliente
   */
  public String getnombredelcliente()
  {
    return nombredelcliente;
  }
  /**
   * Numero de cuenta
   * @return "get" que devuelve el numero de la cuenta 
   */
  public String getnumerodecuenta()
  {
    return numerodecuenta;  
  }
  /**
   * Saldo
   * @return "get" que devuelve la cantidad de dinero que tiene el cliente en la cuenta
   */
  public double getsaldo()
  {
    return saldo;  
  }
  /**
   * Función para ingresar dinero en una cuenta
   * @param cantidadingresar este parametro representa la cantidad de dinero que se quiere ingresar en una cuenta
   * @throws exceptuacion Esta exceptuacion se dispara si esa cantidad dinero que se desea ingresar es menor al minisaldo, es decir si cantidadingresar es menor a 0.
   */
  public void ingresardinero(double cantidadingresar) throws exceptuacion
  {
    if (cantidadingresar < saldominimo)
    {
     throw new exceptuacion ("El saldo tiene que ser mayor que 0");
    }    
    else
    {
     saldo +=cantidadingresar;
    }
  } 
    /**
     * Función para retirar dinero de una cuenta
     * @param cantidadreintegrar este parametro representa la cantidad de dinero que se quiere reintegrar de una cuenta
     * @throws exceptuacion Esta exceptuación se dispara si la cantidad de dinero a reintegrar es mayor al saldo que hay en la cuenta o cuando esa cantidad sea menor a 0. 
     */      
  public void reintegro (double cantidadreintegrar) throws exceptuacion
  {
      if (cantidadreintegrar > saldo || cantidadreintegrar <= saldominimo)
      {
        throw new exceptuacion ("El saldo no es suficiente");
      }
      else
      {
         saldo -=cantidadreintegrar;
      }
  }
  /**
   * Funcion porder hacer transferencias entre cuentas
   * @param transferir Este parametro hace referencia a la cantidad de dinero que se quiere transferir.
   * @param numcuenta Este parametro hace referencia a la cuenta desde la que se hara la tranferencia.
   * @throws exceptuacion La exceptuacion se dispara cuenta la cantidad a tranferir es mayor al saldo que tiene la cuenta desde la que se va a transferir.
   */
  public void transferencia (double transferir, cuenta numcuenta) throws exceptuacion
  {
      if (transferir < saldo) {
         ingresardinero(transferir);
         numcuenta.reintegro(transferir);
      }
      else
        throw new exceptuacion ("Saldo insuficiente");
  }
}       
        
        
        
 
