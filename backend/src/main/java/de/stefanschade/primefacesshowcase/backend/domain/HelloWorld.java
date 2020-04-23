package de.stefanschade.primefacesshowcase.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class HelloWorld  implements Serializable {

    private long id;
    private String content;
    private SimpleEntity se;

    public HelloWorld(long id, String content, SimpleEntity se) {
        this.id = id;
        this.content = content;
        this.se = se;
    }

}