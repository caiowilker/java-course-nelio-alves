package interfaces.ext_fixacao.model.service;

public class PaypalService implements OnlyPaymentService {

    public double paymentFee(Double amount) {
        double result = 0;
        if (amount != null) {
            result = amount + (amount * 0.02);
        }
        else {
            return 0;
        }
        return result;
    }

    public double interest(Double amount, Integer months) {
        double result = 0;
        if (amount != null) {
            result = amount + (amount * 0.01 * months);
        }
        else {
            return 0;
        }
        return result;
    }
}
