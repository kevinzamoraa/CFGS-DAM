package kevinzamora.prog07_tarea;

public class CCuenta {


    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;
    
    /** 
     * Este método representa el constructor vacio de la clase CCuenta
     **/
    public CCuenta() {
        
    }
    /**
     * Este método representa el constructor principal de la clase CCuenta Y en
     * consecuencia, dicho método recibe los siguientes parámetros:
     *
     * @param nom String requerido para poder usar el nombre del usuario en
     * cuestión
     * @param cue Variable 'string' contenedora del número de la cuenta
     * referente al usuario en cuestión
     * @param sal Variable de tipo numérico 'double' contenedora del saldo/
     * importe disponible en la cuenta del usuario en cuestión
     * @param tipo Variable de tipo 'double' contenedora del valor del interés
     * aplicado o a aplicar soble el saldo/efectivo disponible en la cuenta del
     * usuario en cuestión
     **/
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
    }
    
    // Métodos GETTER y SETTER
    
    /** 
     * Devuelve el valor de la variable/propiedad privada 'nombbre'
     * @return nombreEnBD
     **/
    public String getNombre() {
        String nombreEnBD = nombre;
        return nombreEnBD;
    }
    
    /** 
     * Inserta el valor aportado mediante el parámetro nombreIntroducido 
     * en la propiedad/variable de clase 'nombre' 
     * @param nombreIntroducido Inserta el nombre deseado/introducido
     **/
    public void setNombre(String nombreIntroducido) { 
        nombre = nombreIntroducido;
    }
    
    /** Función que nos devuelve una cadena de texto con la cuenta del 
     * usuario en cuestión
     * @return cuentaEnBD
     **/
    public String getCuenta() {
        String cuentaEnBD = cuenta;
        return cuentaEnBD;
    }
    
    /** 
     * Inserta el parámetro introducido en la variable/propiedad 'cuenta'
     * @param cuentaIntroducida Inserta la cuenta del usuario seleccionado
     **/
    public void setCuenta(String cuentaIntroducida) {
        
        cuenta = cuentaIntroducida;
    }
    
    /** 
     * Devuelve el valor de la variable/propiedad 'saldo'
     * @return saldoEnDB
     **/
    public double getSaldo() {
        double saldoEnDB = saldo;
        return saldo;
    }
    
    /**
     * Inserta el valor pasado por parámetro en la variable/propiedad 'saldo'
     * @param saldoIntroducido Inserta la cantidad/el saldo a ingresar/retirar
     **/
    public void setSaldo(double saldoIntroducido) {
        saldo = saldoIntroducido;
    }
    
    /**
     * Devuelve el valor de la variable/propiedad 'tipoInterés'
     * @return tipoInterés
     **/
    public double getTipoInteres() {
        return tipoInterés;
    }
    
    /**
     * Inserta el valor del parámetro introducido en el parámetro/variable 
     * 'tipoInterés'
     * @param tipoInteresIntroducido Inserta el valor del tipo de interés
     **/
    public void setTipoInteres(double tipoInteresIntroducido) {
        tipoInterés = tipoInteresIntroducido;
    }
    
    /**
     * Devuelve el estado de la cuenta en cuestión, resultando en este caso el saldo 
     * del que se dispone en esta
     * @return saldoEnDB
     **/
    public double estado()
    {
        double saldoEnDB = saldo;
        return saldo;
    }
    
    /**
     * Fúnción/Método referente a y contenedor de la funcionalidad necesaria 
     * para poder ingresar efectivo en la cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Se muestra el error "No se puede ingresar una cantidad negativa" 
     * cuando se intenta ingresar un valor inferior a 0
     **/
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }
    
    /**
     * Función/Método contenedor de la funcionalidad necesaria para poder 
     * retirar cierta cantidad pasada vía parámetro del saldo disponible en la 
     * cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Muestra un error distinto en base a dos supuestos: valor 
     * negativo y saldo insuficiente
     **/
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }
}
