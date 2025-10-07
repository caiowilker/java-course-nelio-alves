package interfaces.ext_fixacao.model.service;

public interface OnlyPaymentService {

    double paymentFee(Double amount);
    double interest(Double amount, Integer months);

}
