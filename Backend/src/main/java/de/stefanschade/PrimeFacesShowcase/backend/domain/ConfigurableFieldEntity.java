package de.stefanschade.PrimeFacesShowcase.backend.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"template","fieldname"})})
public class ConfigurableFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template", nullable = false)
    @NonNull
    @JsonBackReference
    ProductTemplateEntity template;

    @Column(nullable = false)
    @NonNull
    private String fieldname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private FieldType fieldType;
    

}