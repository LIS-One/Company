package telran.employee.dao;

import telran.employee.model.Employee;

public interface Company {
    final String COUNTRY = "ISRAEL";
    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quantity();

    double totalSalary();

    default double avgSalary(){
     return totalSalary()/quantity();
    }

    double totalSales();

    void printEmployees();

    Employee[] findEmployeesHoursGreaterThan(int hours);

    Employee[] findEmployeesSalaryBetween(int minSalary,int maxSalary);
}
