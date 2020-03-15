import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

public class LambdaProgram {
    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("printing from the Runnable.");
//            }
//        }).start();
        new Thread(()-> {
            System.out.println("printing from the line1");
            System.out.println("printing from the line2");
            System.out.println("printing from the line3");
            System.out.println("printing from the line4");
            System.out.println(String.format("This is line %d", 5));
        }).start();

        Employee john = new Employee("John Doe", 20);
        Employee tim = new Employee("Time Bucha", 20);
        Employee jack = new Employee("Jack yao", 19);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(jack);
        employeeList.add(snow);

//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });


        Collections.sort(employeeList, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        Collections.sort(employeeList, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for(Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }
}

class CodeToRun implements Runnable
{
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

class  Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
