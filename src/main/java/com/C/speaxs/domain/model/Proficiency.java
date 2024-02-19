package com.C.speaxs.domain.model;

import com.C.speaxs.domain.model.enums.ProficiencyLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Proficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @ManyToOne
    private Language language;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProficiencyLevel level;
}
