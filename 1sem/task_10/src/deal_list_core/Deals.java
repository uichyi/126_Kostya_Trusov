package deal_list_core;

import java.util.HashMap;

public class Deals {
    private String date;
    private HashMap<Integer, PaymentDocument> paymentDocuments;

    public Deals(String date){
        this.date = date;
        paymentDocuments = new HashMap<>();
    }
    public void addPaymentDocument(int sum, int number, PaymentDocumentType paymentType, String date){
        paymentDocuments.put(number, new PaymentDocument(sum, paymentType, date));
    }
    public int getPaymentDocumentsCount(){
        return paymentDocuments.size();
    }
    public HashMap<Integer, PaymentDocument> getPaymentDocuments(){
        return paymentDocuments;
    }
    public int getPaymentsSum(){
        int sum = 0;
        for (PaymentDocument document : paymentDocuments.values()){
            sum += document.getSum();
        }
        return sum;
    }
}
