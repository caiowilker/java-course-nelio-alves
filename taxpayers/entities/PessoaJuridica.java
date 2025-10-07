package taxpayers.entities;

public class PessoaJuridica extends TaxPayers{
    private Integer numberFuncionario;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String name, Double rendaAnual, Integer numberFuncionario) {
        super(name, rendaAnual);
        this.numberFuncionario = numberFuncionario;
    }

    @Override
    public double impostoPago() {
        double renda = 0;
        if (getNumberFuncionario() <= 10) {
            renda = getRendaAnual() * 0.16;
        }else {
            renda = getRendaAnual() * 0.14;
        }
        return renda;
    }


    public Integer getNumberFuncionario() {
        return numberFuncionario;
    }

    public void setNumberFuncionario(Integer numberFuncionario) {
        this.numberFuncionario = numberFuncionario;
    }
}
