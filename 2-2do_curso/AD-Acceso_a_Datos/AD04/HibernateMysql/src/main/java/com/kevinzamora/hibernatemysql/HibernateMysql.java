/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.hibernatemysql;

import com.kevinzamora.hibernatemysql.controller.EmployeeDAO;
import com.kevinzamora.hibernatemysql.model.Dept;
import com.kevinzamora.hibernatemysql.model.Emp;

import java.util.List;

/**
 *
 * @author kzdesigner
 */
public class HibernateMysql {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Insertar un empleado
        /*Emp emp = new Emp();
        emp.setEmpno(1000);
        emp.setName("Kevin");
        emp.setSalary(50000.0);
        emp.setComm(0.0);
        employeeDAO.insertEmp(emp);*/

        // Obtener lista de empleados
        List<Emp> employees = employeeDAO.listEmps();
        List<Dept> departaments = employeeDAO.listDept();
        System.out.println("Lista de empleados:");
        for (Emp e : employees) {
            for (Dept d : departaments) {
                if (d.getDeptno() == e.getDeptno()) {
                    System.out.println(e.toString() + ", " + d.toString());
                    System.out.println(e.getEmpno() + " - Nombre:" + e.getName() + ", Salario: " + e.getSalary()
                            + "€, Departamento: " + d.getName() + ", Localización: " + d.getLocation());
                }
            }
        }

        // Borrar un empleado
        /* Para comprobar si funciona la siguiente línea, basta con restaurar nuestra base de datos, comprobarlo y luego
        ejecutar el programa */
        employeeDAO.deleteEmp(4521); // Suponiendo que el ID del empleado es 4521
        System.out.println("Se ha borrado el empleado con el código 'empno' 4521");

    }
}
