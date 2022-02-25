package base;


public class Pessoa extends Object {
    private String nome;
    private int idade;

    // construtor default
    public Pessoa() {
        nome = "Não cadastrado";
        idade = 0;
    }

    // Overload = sobrecarga de métodos
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    @Override // sobrescrita do método
    public String toString() {
        return nome + " - " + idade;
    }
    
}