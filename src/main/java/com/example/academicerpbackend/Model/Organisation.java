package com.example.academicerpbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORGANISATIONS")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;

    public Set<Organisation_Hr> getOrganisationHr() {
        return organisationHr;
    }

    public void setOrganisationHr(Set<Organisation_Hr> organisationHr) {
        this.organisationHr = organisationHr;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organisation")
    private Set<Organisation_Hr> organisationHr;
    public Organisation() {
    }


    public Organisation(String name, String address, Set<Organisation_Hr> organisationHr) {
        this.name = name;
        this.address = address;
        this.organisationHr = organisationHr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
