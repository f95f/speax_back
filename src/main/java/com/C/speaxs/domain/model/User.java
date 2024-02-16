package com.C.speaxs.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotBlank
    @Size(max = 128)
    private String firstName;

    @Size(max = 128)
    private String lastName;

    @NotBlank
    @Email
    @Size(max = 128)
    private String email;

    @NotBlank
    @Size(max = 128)
    private String password;

    @Size(max = 20)
    private String phone;

    @Size(max = 512)
    private String bio;

    private boolean isActive;

    @NotNull
    private Date birthDate;

    private Location birthLocation;
    private Location currentLocation;

    private Date createdAt;
    private Date updatedAt;

    //TODO: set createdAt automatically
    //TODO: set isActive to false by default
}
