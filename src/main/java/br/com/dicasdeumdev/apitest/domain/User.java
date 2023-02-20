package br.com.dicasdeumdev.apitest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;

    @Column(unique = true)
    private String emial;
    private String passwaord;


}
