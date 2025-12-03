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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "manutencao")
public class Manutencao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "man_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "man_impressora_id", nullable = true)
    private Impressora impressora;


    @Column(name = "hist_modelo")
    private String historicoModelo;

    @Column(name = "hist_sn")
    private String historicoSN;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "hist_setor")
    private Setor setor;

    @Column(name = "man_data_ida", nullable = false)
    private LocalDate dataManutencao;

    @Column(name = "man_data_retorno")
    private LocalDate dataRetorno;

    @Column(name = "man_problema", nullable = false)
    private String problema;

    public Manutencao() {
    }


    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Impressora getImpressora() { return impressora; }


    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
        if (impressora != null) {
            this.historicoModelo = impressora.getModelo().getDescricao();
            this.historicoSN = impressora.getSerialNumber();
            if (impressora.getAlocacao() != null) {
                this.setor = impressora.getAlocacao().getSetor();
        }
    }}

    public String getHistoricoModelo() { return historicoModelo; }
    public void setHistoricoModelo(String historicoModelo) { this.historicoModelo = historicoModelo; }

    public String getHistoricoSN() { return historicoSN; }
    public void setHistoricoSN(String historicoSN) { this.historicoSN = historicoSN; }

    public LocalDate getDataManutencao() { return dataManutencao; }
    public void setDataManutencao(LocalDate dataManutencao) { this.dataManutencao = dataManutencao; }

    public LocalDate getDataRetorno() { return dataRetorno; }
    public void setDataRetorno(LocalDate dataRetorno) { this.dataRetorno = dataRetorno; }

    public String getProblema() { return problema; }
    public void setProblema(String problema) { this.problema = problema; }

    public Setor getSetor() { return setor; }
    public void setSetor(Setor setor) { this.setor = setor; }

    



    public String exibirDados() {
StringBuilder aux = new StringBuilder("Dados da Manutenção:\n");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String mod = (impressora != null) ? impressora.getModelo().getDescricao() : historicoModelo + " (Excluída)";
        String sn = (impressora != null) ? impressora.getSerialNumber() : historicoSN;
        String setorDesc = (setor != null) ? setor.getDescricao() : "Não informado/Sem alocação";

        aux.append("Modelo: ").append(mod).append("\n");
        aux.append("SN: ").append(sn).append("\n");
        
        aux.append("Setor de Origem: ").append(setorDesc).append("\n");
        
        aux.append("Data Ida: ").append(getDataManutencao().format(fmt)).append("\n");
        
        if (getDataRetorno() != null) {
            aux.append("Data Retorno: ").append(getDataRetorno().format(fmt)).append("\n");
        } else {
            aux.append("Data Retorno: Pendente\n");
        }
        aux.append("Motivo: ").append(getProblema()).append("\n");
        
        return aux.toString();
    }
    
    @Override
    public String toString() {
        return "Manutencao #" + id;
    }
}