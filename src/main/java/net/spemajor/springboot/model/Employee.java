package net.spemajor.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")

public class Employee 
{
    // Setting Id as a P.K.
    @Id

    // Making Identity as parallel key generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Creating columns
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id")
    private String emailId;   
}