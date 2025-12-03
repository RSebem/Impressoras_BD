/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author renahn.sebem
 */
@Entity
@Table(name = "Alocacao")
public class Alocacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "alocacao_id")
    private int id;
    
    @Column(name = "alocacao_data", nullable = false)
    private LocalDate dataAlocacao;
    
    @Column(name = "alocacao_IP", nullable = false)
    private String IP;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Alocacao_setor")
    private Setor setor;
    
    @OneToOne(cascade = {jakarta.persistence.CascadeType.MERGE})
    @JoinColumn(name = "Alocacao_impressora")
    private Impressora impressora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(LocalDate dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
        if (impressora != null) {
            impressora.setAlocacao(this);
        }
    }
    public String exibirDados() {
        
        String aux = "Dados da Alocação:\n";
        aux += "Modelo:"+getImpressora().getModelo()+"\n";
        aux += "IP: "+getIP()+"\n";
        aux += "Setor: "+setor+"\n";
        aux += "Data: "+dataAlocacao+"\n";
        aux += "SN: "+getImpressora().getSerialNumber()+"\n";

          return aux;
    }

}
