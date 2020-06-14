package com.wds.index;

public class UserObj {

    private String firstName;
    private String lastName;
    private String value;

    public UserObj(String firstName, String lastName, String value) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.value = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
