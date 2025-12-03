/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author renahn.sebem
 */
public enum Setor {

    // --- ADMINISTRATIVO / APOIO ---
    ALMOXARIFADO("Almoxarifado"),
    CENTRAL_AUTORIZACOES("Central de Autorizações"),
    CENTRAL_CONTAS("Central de Contas"),
    CONTABILIDADE("Contabilidade"),
    COREME("Coreme"),
    DEPARTAMENTO_PESSOAL("Departamento Pessoal"),
    ENGENHARIA_CLINICA("Engenharia Clínica"),
    ENSINO_E_PESQUISA("Ensino e Pesquisa"),
    FATURAMENTO("Faturamento"),
    FINANCEIRO("Financeiro"),
    MANUTENCAO("Manutenção"),
    OBRAS_CASSIOS("Obras (Cassios)"),
    SAME_CENTRO_LOGISTICO("SAME (Centro Logístico)"),
    SCIH_NIR("SCIH NIR"),
    TRANSPORTE_ARICRIS("Transporte (Aricris)"),

    // --- AMBULATÓRIOS / CONSULTÓRIOS ---
    AMBULATORIO_BELLA_CITTA("Ambulatório Bella Città"),
    AMBULATORIO_HC_ATITUS("Ambulatório HC/Atitus"),
    AMBULATORIO_SUS_QUARTEL_A("Ambulatório SUS Quartel A"),
    AMBULATORIO_SUS_QUARTEL_B("Ambulatório SUS Quartel B"),
    CENTRAL_CONSULTAS("Central Consultas"),
    CENTRAL_CONSULTAS_TESOURARIA("Central Consultas (Tesouraria)"),
    CONSULTORIO_CLINICA_CIRURGICA("Consultório de Clínica Cirúrgica"),
    CONSULTORIO_CLINICA_MEDICA("Consultório de Clínica Médica"),
    CONSULTORIO_TRAUMA("Consultório de Trauma"),
    CONSULTORIO_MULTI("Consultório Multi"),
    CONSULTORIO_PEDIATRIA("Consultório Pediatria"),
    HC_CLINICAS_ORTOPEDIA("HC Clínicas Ortopedia"),
    HC_CLINICAS_RECEPCAO("HC Clínicas Recepção"),

    // --- BLOCO CIRÚRGICO (Atualizado) ---
    BLOCO_CIRURGICO_ENFERMEIROS("Bloco Cirúrgico - Enfermeiros"),
    BLOCO_CIRURGICO_FARMACIA("Bloco Cirúrgico - Farmácia"),
    BLOCO_CIRURGICO_RECEPCAO("Bloco Cirúrgico - Recepção"),
    BLOCO_CIRURGICO_RECUPERACAO("Bloco Cirúrgico - Recuperação"),
    BLOCO_CIRURGICO_SALA_13("Bloco Cirúrgico - Sala 13"),
    BLOCO_CIRURGICO_SALA_17("Bloco Cirúrgico - Sala 17"),
    CME("CME"),

    // --- CD (CENTRO DIAGNÓSTICO) ---
    CD_ENTREGA_EXAMES("CD Entrega de Exames"),
    CD2("CD2"),
    CD2_RAIO_X("CD2 Raio X"),
    CD4("CD4"),
    CD4_SALA_PREPARO("CD4 Sala de Preparo"),

    // --- EMERGÊNCIA ---
    EMERGENCIA_PEDIATRICA("Emergência Pediátrica"),
    INFORMACOES_PS("Informações PS"),
    POSTO_02_EMERGENCIA("Posto 02 Emergência"),
    POSTO_EMERGENCIA("Posto Emergência"),
    POSTO_ENFERMAGEM_PA("Posto Enfermagem P.A."),
    PS_EMERGENCIA_RECEPCAO("P.S. Emergência Recepção"),
    RAIO_X_EMERGENCIA("Raio-X Emergência"),
    SALA_CLASSIFICACAO_RISCO("Sala de Classificação de Risco"),
    SALA_VERMELHA_EMERGENCIA("Sala Vermelha Emergência"),

    // --- FARMÁCIA ---
    CENTRO_LOGISTICO_FARMACOTECNICA("Centro Logístico Farmacotécnica"),
    FARMACIA_CENTRAL("Farmácia Central"),
    FARMACIA_INTERNA("Farmácia Interna"),
    FARMACIA_ONCOLOGIA("Farmácia Oncologia"),

    // --- INTERNAÇÃO / POSTOS ---
    HPBM("HPBM"),
    INTERNACOES_SELECT("Internações Select"),
    PEDIATRIA_POSTO_54("Pediatria Posto 54"),
    POSTO_01("Posto 01"),
    POSTO_05("Posto 05"),
    POSTO_06("Posto 06"),
    POSTO_07("Posto 07"),
    POSTO_08("Posto 08"),
    POSTO_09_SELECT("Posto 09 Select"),
    POSTO_11("Posto 11"),
    POSTO_20("Posto 20"),
    POSTO_22("Posto 22"),
    POSTO_24("Posto 24"),
    POSTO_26("Posto 26"),
    SR3_SELECT("SR3 Select"),

    // --- LABORATÓRIO / EXAMES ---
    ENTREGA_DE_EXAMES("Entrega de Exames"),
    LAB_HC_ANALISES("Lab HC Lab de Análises"),
    LAB_HC_PARTICULAR_TERREO("Lab HC Particular Térreo"),
    LAB_HC_SUS_QUARTEL("Lab HC SUS Quartel"),
    RESSONANCIA_COMANDO("Ressonância Comando"),
    RESSONANCIA_RECUPERACAO_3("Ressonância Recuperação 3"),

    // --- OUTROS SERVIÇOS MÉDICOS ---
    FISIOTERAPIA("Fisioterapia"),
    HEMODIALISE("Hemodiálise"),
    HEMODINAMICA("Hemodinâmica"),
    NUTRICAO("Nutrição"),
    ONCOLOGIA("Oncologia"),
    PRESCRICAO_MEDICA("Prescrição Médica"),
    PRONTO_ATENDIMENTO("Pronto Atendimento"),
    PSICOLOGIA_CLINICA("Psicologia Clínica"),
    PSICOLOGIA_HOSPITALAR("Psicologia Hospitalar"),
    RADIOTERAPIA("Radioterapia"),
    SECRETA_PRESCRICAO("Secreta Prescrição"),
    SERVICO_SOCIAL("Serviço Social"),
    SONDARIO("Sondário"),
    TERAPIA_OCUPACIONAL("Terapia Ocupacional"),
    UCR("UCR"),
    UDTA("UDTA"),
    UNIDADE_TRANSFUSIONAL("Unidade Transfusional"),

    // --- RECEPÇÕES GERAIS ---
    INFORMACOES_RECEPCAO("Informações/Recepção"),
    RECEPCAO_SER_MULHER("Recepção Ser Mulher"),

    // --- UTIS ---
    UTI_2("UTI-2"),
    UTI_A("UTI-A"),
    UTI_NEO("UTI-NEO"),
    UTI_PEDIATRICA("UTI Pediátrica"),
    UTI_SELECT("UTI-SELECT");

    private final String descricao;

    Setor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static Setor fromString(String text) {
        for (Setor s : Setor.values()) {
            if (s.descricao.equalsIgnoreCase(text)) {
                return s;
            }
        }
        try {
            return Setor.valueOf(text);
        } catch (IllegalArgumentException e) {
             return null;
        }
    }
}

