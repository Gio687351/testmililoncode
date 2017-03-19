package refactula.micro.futuristic.model;

public final class BillingDetails {
    private final CreditCardNumber creditCardNumber;
    private final CVCode cvCode;

    public BillingDetails(CreditCardNumber creditCardNumber, CVCode cvCode) {
        this.creditCardNumber = creditCardNumber;
        this.cvCode = cvCode;
    }

    public CreditCardNumber getCreditCardNumber() {
        return creditCardNumber;
    }

    public CVCode getCvCode() {
        return cvCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingDetails that = (BillingDetails) o;

        if (creditCardNumber != null ? !creditCardNumber.equals(that.creditCardNumber) : that.creditCardNumber != null)
            return false;
        return cvCode != null ? cvCode.equals(that.cvCode) : that.cvCode == null;
    }

    @Override
    public int hashCode() {
        int result = creditCardNumber != null ? creditCardNumber.hashCode() : 0;
        result = 31 * result + (cvCode != null ? cvCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
                "creditCardNumber=" + creditCardNumber +
                ", cvCode=" + cvCode +
                '}';
    }
}
