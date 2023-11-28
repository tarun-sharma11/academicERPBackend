package com.example.academicerpbackend.Model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORGANISATION_HR",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email_constraint")
})
public class Organisation_Hr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Name cannot be null")
    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @NotNull(message = "Name cannot be null")
    @Column(name = "EMAIL",unique = true)
    private String email;

    @Column(name = "CONTACT_NUMBER")
    private int contact_number;
    @ManyToOne(targetEntity = Organisation.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID",referencedColumnName = "id", nullable = false)
    private Organisation organisation;

    public Organisation_Hr() {
    }

    public Organisation_Hr(String first_name, String last_name, String email, int contact_number, Organisation organisation) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.contact_number = contact_number;
        this.organisation = organisation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }


}