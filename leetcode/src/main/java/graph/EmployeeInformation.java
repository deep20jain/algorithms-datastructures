package graph;

import java.util.List;

/**
 * Created by deep20jain on 10-03-2018.
 */
public class EmployeeInformation {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            if(employees==null) return 0;
            Employee employee = getEmployee(employees, id);
            int importance = employee.importance;
            for (int emp: employee.subordinates) {
                importance += getImportance(employees, emp);
            }
            return importance;
        }

        private Employee getEmployee(List<Employee> employees, int id) {
            for(Employee employee:employees)
                if(employee.id==id) return employee;
            return null;
        }
    }
}
