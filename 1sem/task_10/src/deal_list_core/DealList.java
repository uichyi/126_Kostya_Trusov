package deal_list_core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DealList {

    private HashMap<String, Deals> deals;

    private DealList(){
        deals = new HashMap<>();
    }

    public void addContract(String contractNumber, String date){
        if (deals.containsKey(contractNumber)){
            System.out.println("Такой договор уже был заключен");
        }
        else {
            if (contractNumber != null && String.valueOf(date).length() == 8){
                deals.put(contractNumber, new Deals(date));
            }
            else {
                System.out.println("Введите данные еще раз");
            }
        }
    }
    public void addPaymentDocument(int sum, int orderNumber, PaymentDocumentType paymentType, String contractNumber, String date){
        if (sum > 0 && orderNumber > 0 && String.valueOf(date).length() == 8){
            deals.get(contractNumber).addPaymentDocument(sum, orderNumber, paymentType, date);
        }
        else {
            System.out.println("Введите данные еще раз");
        }
    }

    public HashMap<String, Deals> getDeals(){
        return deals;
    }

    public int getContractsCount(){
        return deals.size();
    }

    public static DealList create(){
        return new DealList();
    }
    public void deletePayment(int orderNumber, String contractNumber, String date){
        if (orderNumber > 0 && contractNumber != null && String.valueOf(date).length() == 8) {
            deals.get(contractNumber).getPaymentDocuments().remove(orderNumber);
        }
        else {
            System.out.println("Введите данные еще раз");
        }
    }
    public List<Integer> getListOfPayments(){
        List<Integer> ListOfPayments = new ArrayList<>();
        for (Deals dls : deals.values()){
            for (PaymentDocument payDocument : dls.getPaymentDocuments().values()){
                ListOfPayments.add(payDocument.getSum());
            }
        }
        return ListOfPayments;
    }
}
