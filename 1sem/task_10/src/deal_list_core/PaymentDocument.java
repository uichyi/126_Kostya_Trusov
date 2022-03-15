package deal_list_core;

public class PaymentDocument {
    private int sum;
    private PaymentDocumentType PaymentType;
    private String date;

    public PaymentDocument(int sum, PaymentDocumentType PaymentType, String date){
        this.sum = sum;
        this.PaymentType = PaymentType;
        this.date = date;
    }

    public int getSum(){
        return sum;
    }
}
