package deal_list_core;

import java.util.HashMap;

public class DealList {

    private HashMap<String, Deals> deals;

    private DealList(){
        deals = new HashMap<>();
    }

    public void addContract(String number, String date){
        if (deals.containsKey(number)){
            System.out.println("Такой договор уже был заключен");
        }
        else {
            if (number != null && String.valueOf(date).length() == 8){
                deals.put(number, new Deals(date));
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
    public int getListOfPayments(){
        return 25000000;
    }
}
