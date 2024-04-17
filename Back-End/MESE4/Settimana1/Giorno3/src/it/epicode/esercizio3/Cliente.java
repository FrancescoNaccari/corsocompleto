package it.epicode.esercizio3;

public class Cliente {

    private String nome;
    private String cognome;
    private String codiceCliente;
    private String email;
    private String dataIscrizione;

    public Cliente(String nome, String cognome, String codiceCliente, String email, String dataIscrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceCliente = codiceCliente;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(String dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
}
