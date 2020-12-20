package Solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {
    private Map<Integer, Employee> employeesMap;

    @Test
    public void shouldAnswerWithTrue() {
        // given
        List<Integer> e1List = new ArrayList<Integer>();
        e1List.add(2);
        e1List.add(3);
        Employee e1 = new Employee(1, 5, e1List);
        List<Integer> e2List = new ArrayList<Integer>();
        e2List.add(4);
        Employee e2 = new Employee(2, 3, e2List);
        Employee e3 = new Employee(3, 3, new ArrayList<Integer>());
        Employee e4 = new Employee(4, 1, new ArrayList<Integer>());
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        // when
        int importance = getImportance(employees, 1);

        // then
        assertEquals(12, importance);
    }

    public int getImportance(List<Employee> employees, int id) {
        employeesMap = new HashMap<Integer, Employee>();
        for (Employee e : employees) {
            employeesMap.put(e.id, e);
        }
        if (!employeesMap.containsKey(id))
            return 0;
        return getSubordinateImportance(new ArrayList<Integer>(id), id);
    }

    public int getSubordinateImportance(List<Integer> employeeIds, int id) {
        Employee e = employeesMap.get(id);
        int importance = e.importance;
        if (e.subordinates.isEmpty()) {
            return e.importance;
        } else {
            for (Integer seId : e.subordinates) {
                importance += getSubordinateImportance(e.subordinates, seId);
            }
        }
        return importance;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}