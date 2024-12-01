package telran.employee.dao;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyImpl implements Company {
    private List<Employee> employees;
    private int capacity;

    public CompanyImpl(int capacity) {
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
//0(n)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || capacity == employees.size() || findEmployee(employee.getId()) != null) {
            return false;
        }
        return employees.add(employee);
    }
//0(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
    }
//0(n)
    @Override
    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
//0(1)
    @Override
    public int quantity() {
        return employees.size();
    }
//0(n)
    @Override
    public double totalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calcSalary();
        }

        return sum;
    }
//0(n)
    @Override
    public double totalSales() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager sm)
                sum += sm.getSalesValue();
        }
        return sum;
    }



//0(n)
    @Override
    public void printEmployees() {
        System.out.println("====="+COUNTRY+"======");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("=======================");
    }
////0(n)
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {

        return findEmployeesByPredicate(e->e.getHours()>hours);

    }
//0(n)
    @Override
    public Employee[] findEmployeesSalaryBetween(int minSalary, int maxSalary) {

          return findEmployeesByPredicate(e->e.calcSalary()>=minSalary && e.calcSalary()<maxSalary);
        }
//0(n)
private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate){
    List<Employee> res = new ArrayList<>();
    for(Employee employee:employees){
        if(predicate.test(employee)){
            res.add(employee);
        }
    }

    return res.toArray(new Employee[0]);
}}

