package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "impressoras")
public class Impressora implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "impr_id")
    private int id;

    @Column(nullable = false, unique = true, name = "impr_SN")
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "impr_nome")
    private Modelo modelo;

    @Column(name = "impr_disponivel")
    private Boolean disponivel;

    @OneToOne(mappedBy = "impressora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Alocacao alocacao;

    @OneToMany(mappedBy = "impressora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manutencao> historicoManutencao = new ArrayList<>();

    public List<Manutencao> getHistoricoManutencao() {
        return historicoManutencao;
    }

    public void setHistoricoManutencao(List<Manutencao> historicoManutencao) {
        this.historicoManutencao = historicoManutencao;
    }

    public Impressora() {
        this.disponivel = true; 
    }

    public Impressora(String serialNumber) {
        this.serialNumber = serialNumber;
        this.disponivel = true;
    }

    // --- Getters e Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Alocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;
        // Lógica automática de disponibilidade
        if (alocacao != null) {
            this.disponivel = false;
        } else {
            this.disponivel = true;
        }
    }

    // toString crucial para os ComboBoxes de Alocação e Manutenção
    @Override
    public String toString() {
        if (this.modelo != null) {
            return this.modelo.getDescricao() + " - SN: " + this.serialNumber;
        }
        return "";
    }

    public String exibirDados() {
        String aux = "Impressora Cadastrada:\n";
        aux += "Modelo: " + (modelo != null ? modelo.getDescricao() : "N/A") + "\n";
        aux += "SN: " + serialNumber + "\n";
        aux += "Status: " + (disponivel ? "Disponível" : "Alocada") + "\n";
        return aux;
    }
}
