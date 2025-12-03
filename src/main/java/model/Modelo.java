package model;

/**
 *
 * @author renahn.sebem
 */
public enum Modelo {

    HP_LASERJET_400_M401DNE("HP LaserJet 400 M401dne"),
    HP_LASERJET_400_M401N("HP LaserJet 400 M401n"),
    HP_LASERJET_400_MFP_M425DN("HP LaserJet 400 MFP M425dn"),
    HP_LASERJET_M1536DNF_MFP("HP LaserJet M1536dnf MFP"),
    HP_LASERJET_M402DN("HP LaserJet M402dn"),
    HP_LASERJET_MFP_M426DW("HP LaserJet MFP M426dw"),
    HP_LASERJET_MFP_M426FDW("HP LaserJet MFP M426fdw"),
    HP_LASERJET_MFP_M428FDW("HP LaserJet MFP M428fdw"),
    HP_LASERJET_PROFESSIONAL_M1212NF_MFP("HP LaserJet Professional M1212nf MFP"),
    HP_LASERJET_PROFESSIONAL_P1606DN("HP LaserJet Professional P1606dn"),
    HP_M12W("HP M12w"), 

    HP_LASERJET_PRO_M404DW("HP LaserJet Pro M404dw"),
    HP_LASERJET_PRO_MFP_4103FDW("HP LaserJet Pro MFP 4103fdw"),
    HP_LASERJET_PRO_MFP_M127FN("HP LaserJet Pro MFP M127fn"),
    HP_LASERJET_PRO_MFP_M26NW("HP LaserJet Pro MFP M26nw"),
    HP_LASERJET_PRO_MFP_M402("HP LaserJet Pro MFP M402"),
    HP_LASERJET_PRO_MFP_M428DW("HP LaserJet Pro MFP M428dw");

    private final String descricao;

    // Construtor do Enum
    Modelo(String descricao) {
        this.descricao = descricao;
    }

    // Método para pegar o nome formatado
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}