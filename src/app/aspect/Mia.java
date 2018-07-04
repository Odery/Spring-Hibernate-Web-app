package app.aspect;

import app.entity.Customer;

public class Mia {

    // 66
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setFirstName("Roger");
        customer.setLastName("Smith");

        Object[] objects = {"Steve", 2, customer};

        long timeBefore = System.currentTimeMillis();

        for (Object o : objects) {
            System.out.println(o);
        }

        System.out.println("Time: " + (timeBefore - System.currentTimeMillis()));
    }
}
