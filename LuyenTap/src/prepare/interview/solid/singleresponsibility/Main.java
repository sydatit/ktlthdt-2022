package prepare.interview.solid.singleresponsibility;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber(123);
        account.setTotalAmount(BigDecimal.valueOf(10000));
        account.setFirstName("Dat");
        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);

        TransactionOperations transactionOperations = new TransactionOperations();
        transactionOperations.deposit(BigDecimal.valueOf(123), 123);
    }
}
