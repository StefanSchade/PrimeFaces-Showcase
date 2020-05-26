package de.stefanschade.primefacesshowcase.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductTemplateEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long dbId;

    @Column(nullable = false, unique = true) @NonNull private String templatename;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    @Column(nullable = false) @JsonManagedReference private List<ConfigurableFieldEntity> fields;
}
