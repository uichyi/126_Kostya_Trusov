package deal_list_core;

public class DealList {
    private int contractsCount;
    private DealList(){
        contractsCount = 0;
    }
    public void addContract(String number, String date){
        ++contractsCount;
    }
    public int getContractsCount(){
        return contractsCount;
    }
    public static DealList create(){
        return new DealList();
    }
}
