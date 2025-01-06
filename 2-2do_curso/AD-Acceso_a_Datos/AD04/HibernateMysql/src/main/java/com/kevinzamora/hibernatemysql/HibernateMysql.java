/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.hibernatemysql;

import com.kevinzamora.hibernatemysql.controller.EmployeeDAO;
import com.kevinzamora.hibernatemysql.model.Dept;
import com.kevinzamora.hibernatemysql.model.Emp;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author kzdesigner
 */
public class HibernateMysql {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Insertar un empleado
        Emp emp = new Emp();
        emp.setName("KEVIN");
        emp.setJob("SALESMAN");
        emp.setMgr(null);
        emp.setHireDate(LocalDate.of(2025, 1, 6));
        emp.setSalary(50000.0);
        emp.setComm(0.0);
        emp.setDeptno(20);
        employeeDAO.insertEmp(emp);
        System.out.println("El nuevo empleado se ha guardado correctamente");

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
        /* Para comprobar si funciona la siguiente línea, basta con comentar el método 'deleteEmp'
                                                                                   y apreciar como se mantiene el usuario creado */
        employeeDAO.deleteEmp(emp.getEmpno()); // Borramos el usuario creado previamente
        System.out.println("Se ha borrado el empleado creado durante la prueba de inserción");

    }
}
