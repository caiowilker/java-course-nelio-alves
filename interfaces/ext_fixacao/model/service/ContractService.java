package interfaces.ext_fixacao.model.service;

import interfaces.ext_fixacao.model.entities.Contract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ContractService {
    private OnlyPaymentService ops;

    public ContractService(OnlyPaymentService ops) {
        this.ops = ops;
    }

    public void processContract(Contract contract, Integer months) {

        LocalDate localDate = contract.getInstallment().getDueDate();

        double baseInstallment = contract.getTotalValue() / months;

        for (int i = 0; i < months; i++) {
            LocalDate format = localDate.plusMonths(i + 1);
            double interest = ops.interest(baseInstallment, i);
            double total = (ops.paymentFee( interest));
            System.out.println(format + " - " + String.format("%.2f", total));
        }
    }
}
