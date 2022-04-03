
package cuentabancaria;

import java.util.Date;
import java.util.Scanner;

public class CuentaBancaria {

    public static void main(String[] args) throws exceptuacion {
    Scanner sc = new Scanner(System.in);
    // una cuenta
    cuenta primercliente = new cuenta (fecha (), nomcliente (), numcuenta (), saldoI());
    System.out.println("El cliente con numero de cuenta " + primercliente.getnumerodecuenta() + " se registro el " + primercliente.getfechadecreacion());
    //otra cuenta
    cuenta segundocliente = new cuenta (fecha (), nomcliente (), numcuenta (), saldoI());
    System.out.println("El cliente con numero de cuenta " + segundocliente.getnumerodecuenta() + " se registro el " + segundocliente.getfechadecreacion());
    System.out.print("Cuenta con la que desea operar. ");
    String iterar =  numcuenta ();
    String escoger;

    if (iterar.equals(primercliente.getnumerodecuenta())){
        do {
            System.out.println("Operaciones");
                    
            System.out.println("a. Consultar saldo");
            System.out.println("b. Ingresar");
            System.out.println("c. Retirar");
            System.out.println("d. Transferencia");
            System.out.println("e. salir");
            System.out.print("Elija la operacion que desea realizar: ");
          
        escoger = sc.next();
        if (escoger.equals("a")){
          System.out.println("Su saldo es: " + primercliente.getsaldo());
        }
        else if (escoger.equals("b")){
        ingresar(primercliente);
        }
        else if (escoger.equals("c")){
        retirar(primercliente);
        }
        else if (escoger.equals("d")){
        transferir(segundocliente, primercliente);
        }
        }while(!escoger.equals("e"));
    }
    else if (iterar.equals(segundocliente.getnumerodecuenta())){
        do {
            System.out.println("Operaciones");
            System.out.println("a. Consultar saldo");
            System.out.println("b. Ingresar");
            System.out.println("c. Retirar");
            System.out.println("d. Transferencia");
            System.out.println("e. salir");
            
        escoger = sc.next();
        if (escoger.equals("a")){
          System.out.println("Su saldo es: " + segundocliente.getsaldo());
        }
        else if (escoger.equals("b")){
         ingresar(segundocliente);
        }
        else if (escoger.equals("c")){
         retirar(segundocliente);
        }
        else if (escoger.equals("d")){
         transferir(primercliente, segundocliente);
        }
        }while(!escoger.equals("e"));
        
    }else 
    {
        System.out.print("La cuenta " + iterar + "no existe" );
    }
     System.out.println("El saldo de la cuenta " + primercliente.getnumerodecuenta() + "es: " + primercliente.getsaldo());
     System.out.println("El saldo de la cuenta " + segundocliente.getnumerodecuenta() + "es: " + segundocliente.getsaldo());
    } 
    
public static Date fecha ()
{
    Date fechacreacion = new Date();
    return fechacreacion;
}
public static String nomcliente ()
{
    Scanner nom = new Scanner (System.in);
    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = nom.next();
    return nombre;
}
public static String numcuenta ()
{
    Scanner num = new Scanner (System.in);
    System.out.print("Ingrese el numero de cuenta: ");
    String numero = num.next();
    return numero;
}
public static double saldoI()
{
    Scanner sal = new Scanner (System.in);
    System.out.print("Ingrese el saldo: ");
    double saldos = sal.nextDouble();
    return saldos;    
}
public static void ingresar (cuenta valor) throws exceptuacion
{
  Scanner sc = new Scanner (System.in);
  System.out.print("Cuanto desea ingresar:" );
  double ingresos = sc.nextDouble();
  valor.ingresardinero(ingresos);
  System.out.println("Hecho" );
}
public static void retirar (cuenta valor) throws exceptuacion
  {
  Scanner sc = new Scanner (System.in);
  System.out.print("Cuanto desea retirar: ");
  double retiros = sc.nextDouble();
  if(retiros<valor.getsaldo()){
    valor.reintegro(retiros);
    System.out.println("Hecho" );    
  }
  else 
    System.out.print("Saldo no suficiente");
  }
public static void transferir (cuenta valor1, cuenta valor2) throws exceptuacion
{
  Scanner sc = new Scanner (System.in);
  System.out.print("Numero de cuenta a la que desea transferir: ");
  String ncuenta = sc.next();
  if (ncuenta.equals(valor1.getnumerodecuenta()))
  {
   System.out.print("Ingrese el importe: ");
   double cantidad = sc.nextDouble();
   valor1.transferencia(cantidad, valor2);
   System.out.println("Hecho" ); 
  }
  else 
   System.out.println("No existente " + ncuenta + " o operacion invalida.");
}     
}

