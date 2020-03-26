package de.stefanschade.backend.domain;

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
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dbId;

    @Column(nullable = false)
    @NonNull
    private String id;

    @Column(nullable = false)
    @NonNull
    private String categoryName;
}
