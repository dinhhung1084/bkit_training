package Package.management;

import Package.hr.Employee;

public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    public void manage() {
        System.out.println(getName() + " is managing the team.");
    }
}
