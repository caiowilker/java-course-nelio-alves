package taxpayers.entities;

public class PessoaFisica extends TaxPayers{
    private Double gastoSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String name, Double rendaAnual, Double gastoSaude) {
        super(name, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double impostoPago() {
        double renda = 0;

        if (getRendaAnual() < 2000) {
            renda = getRendaAnual() * 0.15;
            if (getGastoSaude() != 0) {
                renda -= getGastoSaude() * 0.50;
            }
        }else {
            renda = getRendaAnual() * 0.25;
            if (getGastoSaude() != 0) {
                renda -= getGastoSaude() * 0.50;
            }
        }
        return renda;
    }
    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }
}
