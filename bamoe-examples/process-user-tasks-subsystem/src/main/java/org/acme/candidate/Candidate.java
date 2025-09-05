
package org.acme.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Candidate {

    private String firstName;
    private String lastName;
    private String position;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @JsonIgnore
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
