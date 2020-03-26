package de.stefanschade.backend.domain;


import de.stefanschade.backend.dto.FieldType;
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
public class ConfigurationFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dbId;

    @Column(nullable = false)
    @NonNull
    private String id;

    @Column(nullable = false)
    @NonNull
    private String fieldName;

    @Column(nullable = false)
    @NonNull
    private Integer fieldLength;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private FieldType fieldType;
}
