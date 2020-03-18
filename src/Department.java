import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<MyEmployee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee (MyEmployee employee) {
        employees.add(employee);
    }

    public List<MyEmployee> getEmployees () {
        return employees;
    }


}
