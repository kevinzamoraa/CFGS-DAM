/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author kzdesigner // Autor: Kevin Zamora Amela
 */
public class Calculadora extends javax.swing.JFrame {
    /* Esta es la clase que implementa/extiende la clase JFrame y mediante la 
    cual hemos ido construyendo nuestra aplicación/calculadora */

    /**
     * Creates new form Calculadora
     */
    
    /* Primeramente, declaramos las variables locales que alojarán los diferentes 
    datos procesados durante la ejecución y puesta en marcha de nuestra aplicación. 
    Gracias a las siguientes variables conseguiremos cierta capacidad de memoria 
    temporal y volatil */
    // En estas dos variables guardaremos los diferentes datos/números introducidos
    double numIntroducido1 = 0;
    double numIntroducido2 = 0;
    /* En esta otra variable iremos guardando y actualizando el resultado de las 
    diferentes operaciones matemáticas */ 
    double resultado;
    /* En la variable memoria iremos guardando el valor/número que esté y hayamos 
    introducido en nuestra 'campo de entrada de texto', justo en el momento en el 
    que hagamos clic sobre el botón 'Memoria' */
    double memoria = 0;
    String operacion = "";
    /* A su vez y mientras vayamos haciendo uso de nuestra aplicación, iremos 
    guardando cada uno de los 'pares de números' introducidos y sus respectivos 
    resultados en una colección a la cual hemos llamado 'historial' */
    ArrayList<String> historial = new ArrayList<String>();
    
    /* Este es el constructor de nuestra clase Calculadora */
    public Calculadora() {
        /* En este inicializamos los componentes necesarios/utilizados en nuestra 
        aplicación Calculadora */
        initComponents();
        /* Posicionamos la ventana en el centro de nuestro/a escritorio/pantalla */
        this.setLocationRelativeTo(null);
        /* Deshabilitamos la edición de nuestro 'campo de entrada' llamado 'outputResultado'.
        En dicho campo se irán cargando/mostrando los resultados de las diferentes 
        operaciones que vayamos realizando */
        outputResultado.setEditable(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputNum = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        resLabel = new javax.swing.JLabel();
        outputResultado = new javax.swing.JTextField();
        btnSum = new javax.swing.JButton();
        btnRes = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnMS = new javax.swing.JButton();
        btnMemoria = new javax.swing.JButton();
        btnC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputNum.setText("0");
        inputNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNumActionPerformed(evt);
            }
        });

        numLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        numLabel.setText("Número");

        resLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        resLabel.setText("Resultado");

        outputResultado.setText("0");
        outputResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputResultadoActionPerformed(evt);
            }
        });

        btnSum.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnSum.setText("Suma");
        btnSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumActionPerformed(evt);
            }
        });

        btnRes.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnRes.setText("Resta");
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });

        btnDiv.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnDiv.setText("Divide");
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        btnMult.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnMult.setText("Multiplica");
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnHistorial.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnMS.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnMS.setText("MS");
        btnMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSActionPerformed(evt);
            }
        });

        btnMemoria.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnMemoria.setText("Memoria");
        btnMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemoriaActionPerformed(evt);
            }
        });

        btnC.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMS))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMemoria))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(resLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(outputResultado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numLabel)
                                        .addGap(31, 31, 31)
                                        .addComponent(inputNum, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(btnC))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numLabel)
                    .addComponent(btnC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resLabel)
                    .addComponent(outputResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMS))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnMemoria)))
                .addGap(18, 18, 18)
                .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnHistorial))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNumActionPerformed
    
    /**
     * Método para realizar una suma entre los dos numeros 
     * introducidos y/o partiendo del resultado anterior guardado en memoria.  Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnSum / Realizamos la operación matemática SUMA / No hemos precisado 
        la creación de un método auxiliar para realizar la operación pertinente */
        if (numIntroducido1 == 0) {
            numIntroducido1 = Double.parseDouble(inputNum.getText());
            outputResultado.setText(String.valueOf(numIntroducido1));
            historial.add(String.valueOf(numIntroducido1));
        } else {
            numIntroducido2 = Double.parseDouble(inputNum.getText());
            resultado = numIntroducido1 + numIntroducido2;
            numIntroducido1 = resultado;
            outputResultado.setText(String.valueOf(resultado));
            historial.add(String.valueOf(numIntroducido2));
            operacion = " suma: ";
            historial.add(String.valueOf(operacion));
            historial.add(String.valueOf(resultado));
        }
    }//GEN-LAST:event_btnSumActionPerformed
    
    /**
     * Método para realizar una resta entre los dos numeros 
     * introducidos y/o partiendo del resultado anterior guardado en memoria.  Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnSum / Realizamos la operación matemática RESTA / No hemos precisado 
        la creación de un método auxiliar para realizar la operación pertinente */
        if (numIntroducido1 == 0) {
            numIntroducido1 = Double.parseDouble(inputNum.getText());
            outputResultado.setText(String.valueOf(numIntroducido1));
            historial.add(String.valueOf(numIntroducido1));
        } else {
            numIntroducido2 = Double.parseDouble(inputNum.getText());
            resultado = numIntroducido1 - numIntroducido2;
            numIntroducido1 = resultado;
            outputResultado.setText(String.valueOf(resultado));
            historial.add(String.valueOf(numIntroducido2));
            operacion = " resta: ";
            historial.add(String.valueOf(operacion));
            historial.add(String.valueOf(resultado));
        }
    }//GEN-LAST:event_btnResActionPerformed
    
    /**
     * Método para realizar una multiplicación entre los dos numeros 
     * introducidos y/o partiendo del resultado anterior guardado en memoria.  Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnMult / Realizamos la operación matemática MULTIPLICACIÓN / No hemos precisado 
        la creación de un método auxiliar para realizar la operación pertinente */
        if (numIntroducido1 == 0) {
            numIntroducido1 = Double.parseDouble(inputNum.getText());
            outputResultado.setText(String.valueOf(numIntroducido1));
            historial.add(String.valueOf(numIntroducido1));
        } else {
            numIntroducido2 = Double.parseDouble(inputNum.getText());
            resultado = numIntroducido1 * numIntroducido2;
            numIntroducido1 = resultado;
            outputResultado.setText(String.valueOf(resultado));
            historial.add(String.valueOf(numIntroducido2));
            operacion = " multiplicación: ";
            historial.add(String.valueOf(operacion));
            historial.add(String.valueOf(resultado));
        }
    }//GEN-LAST:event_btnMultActionPerformed
    
    /**
     * Método para realizar una división entre los dos numeros 
     * introducidos y/o partiendo del resultado anterior guardado en memoria.  Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnDiv / Realizamos la operación matemática DIVISIÓN / No hemos precisado 
        la creación de un método auxiliar para realizar la operación pertinente */
        if (numIntroducido1 == 0) {
            numIntroducido1 = Double.parseDouble(inputNum.getText());
            outputResultado.setText(String.valueOf(numIntroducido1));
            historial.add(String.valueOf(numIntroducido1));
        } else {
            numIntroducido2 = Double.parseDouble(inputNum.getText());
            resultado = numIntroducido1 / numIntroducido2;
            numIntroducido1 = resultado;
            outputResultado.setText(String.valueOf(resultado));
            historial.add(String.valueOf(numIntroducido2));
            operacion = " división: ";
            historial.add(String.valueOf(operacion));
            historial.add(String.valueOf(resultado));
        }
    }//GEN-LAST:event_btnDivActionPerformed
    
    /**
     * Método para reiniciar nuestra aplicación y volver a poner la variable resultado a 0.  Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnMS */
        inputNum.setText("");
        outputResultado.setText("");
        numIntroducido1 = 0;
        numIntroducido2 = 0;
        resultado = 0;
        
        String Fn, Sn;
        
        Fn = String.valueOf(numIntroducido1);
        Sn = String.valueOf(numIntroducido2);
        
        Fn = "";
        Sn = "";
    }//GEN-LAST:event_btnMSActionPerformed
    /**
     * Método para guardar el número introducido en la variable memoria. Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoriaActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnMemoria */
        if (memoria == 0) {
            memoria = Double.parseDouble(inputNum.getText());
        } else {
            showMessageDialog(null, "El número guardado en memoria es: " + memoria 
                    + ". \n Este ha sido cargado en el campo de entrada de texto para poder "
                            + "ser usado.");
            inputNum.setText(String.valueOf(memoria));
            
        }
    }//GEN-LAST:event_btnMemoriaActionPerformed
    
    /**
     * Método para limpiar los datos almacenados (llamada normalmente como C / Clear) y 
     * volver a empezar con nuevas operaciones matemáticas. Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnC / Procedemos al borrado y reinicio de los datos y variables */
        
        /* 
        // Con la siguiente función implementamos anteriormente la función para 
        // poder borrar de uno en uno los números introducidos mediante el campo de entrada
        // La mantenemos aquí adjunta a modo de complemento
        String backSp = null;
        
        if (inputNum.getText().length() > 0) {
            StringBuilder sb = new StringBuilder(inputNum.getText());
            sb.deleteCharAt(inputNum.getText().length() - 1);
            backSp = sb.toString();
            inputNum.setText(backSp);
        } */
        
        inputNum.setText("");
        outputResultado.setText("");
        numIntroducido1 = 0;
        numIntroducido2 = 0;
        resultado = 0;
        
        String Fn, Sn;
        
        Fn = String.valueOf(numIntroducido1);
        Sn = String.valueOf(numIntroducido2);
        historial.clear();
        
        Fn = "";
        Sn = "";
    }//GEN-LAST:event_btnCActionPerformed
    
    /**
     * Método creado para mostrar el historico de operaciones realizadas guardado 
     * previamente en la colección 'historial'. Actua 
     * ante un evento clic sobre el botón correspondiente
     */
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnHistorial */
        if (historial.isEmpty()) {
            showMessageDialog(null, "El historial aún está vacio");
        } else {
            String numHistorial = "";
            if (historial.isEmpty()) {
                    showMessageDialog(null, "Aún no hay números almacenados en "
                            + "el historial");
            }
            int counter = 0;
            for (String num : historial) {
                if (counter < 5) {
                    numHistorial = numHistorial.concat(" | " + String.valueOf(num) + " | ");
                    counter++;
                } else if (counter == 5) {
                    numHistorial = numHistorial.concat("\n | " + String.valueOf(num) + " | ");
                    counter = 0;
                }
            }
            showMessageDialog(null, "Lista de números introducidos: \n " 
                            + numHistorial);
        }
    }//GEN-LAST:event_btnHistorialActionPerformed
    
    /**
     * Método para finalizar nuestra aplicación y cerrar la ventana. Este actua tras 
     * hacer clic sobre el botón 'btnExit'. 
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        /* Este es el método que entra en acción tras un evento de tipo clic sobre el 
        botón btnExit */
        // Cerramos la ventana
        dispose();
        // Y finalizamos la ejecución de nuestra aplicación
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed
    
    private void outputResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputResultadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        Calculadora calculadora = new Calculadora();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMS;
    private javax.swing.JButton btnMemoria;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnRes;
    private javax.swing.JButton btnSum;
    private javax.swing.JTextField inputNum;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField outputResultado;
    private javax.swing.JLabel resLabel;
    // End of variables declaration//GEN-END:variables
}