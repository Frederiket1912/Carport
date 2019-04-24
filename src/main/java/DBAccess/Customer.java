/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

/**
 *
 * @author frede
 */
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String address;
    private int zipcode;
    private String phonenumber;

    public Customer(String name, String email, String address, int zipcode, String phonenumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}
