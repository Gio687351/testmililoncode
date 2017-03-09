package refactula.design.patterns.behavioral.visitor;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.visitor.banking.BankAccount;
import refactula.design.patterns.behavioral.visitor.banking.CardVisitor;
import refactula.design.patterns.behavioral.visitor.banking.CreditCard;
import refactula.design.patterns.behavioral.visitor.banking.SavingCard;

public class VisitorExample {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(ImmutableList.of(
                new CreditCard("Credit01", 300, 2000),
                new SavingCard("Saving01", 500, 0.05),
                new CreditCard("Credit02", 100, 300),
                new SavingCard("Saving02", 0, 0.1)));

        TotalAmount totalAmount = new TotalAmount();
        bankAccount.visit(totalAmount);
        System.out.println("Total amount: " + totalAmount.getAmount());

        MaxInterestRate maxInterestRate = new MaxInterestRate();
        bankAccount.visit(maxInterestRate);
        System.out.println("Max interest rate: " + maxInterestRate.getMaxInterestRate());
    }

    private static class TotalAmount implements CardVisitor {
        private int amount = 0;

        public int getAmount() {
            return amount;
        }

        @Override
        public void visit(SavingCard savingCard) {
            amount += savingCard.getAmount();
        }

        @Override
        public void visit(CreditCard creditCard) {
            amount += creditCard.getAmount();
        }
    }

    private static class MaxInterestRate implements CardVisitor {
        private double maxInterestRate = 0;

        @Override
        public void visit(SavingCard savingCard) {
            maxInterestRate = Math.max(maxInterestRate, savingCard.getInterestRate());
        }

        @Override
        public void visit(CreditCard creditCard) {

        }

        public double getMaxInterestRate() {
            return maxInterestRate;
        }
    }

}
