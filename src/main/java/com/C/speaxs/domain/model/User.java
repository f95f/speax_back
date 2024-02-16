package com.C.speaxs.domain.model;

import com.C.speaxs.domain.model.enums.UserRole;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @ManyToOne
    private Location birthLocation;

    @ManyToOne
    private Location currentLocation;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Date createdAt;
    private Date updatedAt;

    //TODO: set createdAt automatically
    //TODO: set isActive to false by default
    //TODO: set user role as user by default
}
