package org.acme.travel;

public class Traveler {

    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String hotelId;

    private boolean processed;

    public Traveler() {

    }

    public Traveler(String firstName, String lastName, String email, String nationality, String hotelId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.hotelId = hotelId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Traveler [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", nationality="
                + nationality + ", processed=" + processed + ", hotelId=" + hotelId + "]";
    }

}
