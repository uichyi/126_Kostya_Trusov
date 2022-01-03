package deal_list_core;

public class DealList {
    private int contractsCount;
    private int paymentDocumentsCount;
    private DealList(){
        contractsCount = 0;
        paymentDocumentsCount = 0;
    }
    public void addContract(String number, String date){
        ++contractsCount;
    }
    public void addPaymentDocument(int sum, int num, String documentType, String number, String date){
        ++paymentDocumentsCount;
    }
    public int getContractsCount(){
        return contractsCount;
    }
    public static DealList create(){
        return new DealList();
    }
    public int getPaymentDocumentsCount(){
        return paymentDocumentsCount;
    }
}
