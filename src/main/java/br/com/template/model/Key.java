package br.com.template.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "key_api")
@Data
public class Key {

    @Id
    @Column(name="CODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    @Column(name="DESCRICAO")
    private String descricao;

    @Column(name="TOKEN")
    private String token;

}
