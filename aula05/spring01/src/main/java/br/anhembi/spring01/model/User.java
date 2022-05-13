package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // indica que esta classe sera persistida no BD
@Table(name = "tb_user")
public class User {
    @Id // indica que este atributo é PK no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerado pelo BD, 1, 2, 3...
    private long code;

    @Column(name = "nome_user", length = 150, nullable = false)
    private String nome;

    @Column(name = "email_user", length = 50, nullable = false, unique = true)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

}
