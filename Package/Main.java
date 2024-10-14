package Package;

import Package.management.Manager;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("John");
        manager.manage();  // Kết quả: John is managing the team.
    }
}
