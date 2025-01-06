/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.hibernatemysql;

import com.kevinzamora.hibernatemysql.controller.EmployeeDAO;
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
        Emp emp = new Emp();
        emp.setEmpno(1000);
        emp.setName("Kevin");
        emp.setSalary(50000.0);
        employeeDAO.insertEmp(emp);

        // Obtener lista de empleados
        List<Emp> employees = employeeDAO.listEmps();
        for (Emp e : employees) {
            System.out.println(e.getName() + ", Salario: " + e.getSalary());
        }

        // Borrar un empleado
        employeeDAO.deleteEmp(1); // Suponiendo que el ID del empleado es 1

    }
}
