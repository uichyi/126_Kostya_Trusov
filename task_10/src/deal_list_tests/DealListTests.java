package deal_list_tests;

import org.junit.*;
import deal_list_core.*;

public class DealListTests extends Assert{
    @Test
    public void create_CreateEmptyDealList_ContractCountEqualsZero(){
        DealList dealList = DealList.create();
        assertEquals(0, dealList.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsCountEqualsOne(){
        DealList dealList = DealList.create();
        dealList.addContract("1", "20220103");
        assertEquals(1, dealList.getContractsCount());
    }
    @Test
    public void addPaymentDocument_AddPaymentDocument_ContractsCountEqualsOne(){
        DealList dealList = DealList.create();
        dealList.addPaymentDocument(100000, 401,  PaymentDocumentType.PaymentOrder, "1", "20220104");
        assertEquals(1, dealList.getPaymentDocumentsCount());
    }
    @Test
    public void getSum_GetSumOfAllPaymentsWithGivenNumber_SumEquals500000(){
        DealList dealList = DealList.create();
        dealList.addPaymentDocument(100000, 401, PaymentDocumentType.PaymentOrder, "1", "20220104");
        dealList.addPaymentDocument(200000, 402, PaymentDocumentType.PaymentOrder, "1", "20220104");
        dealList.addPaymentDocument(200000, 403, PaymentDocumentType.BankOrder, "1", "20220104");
        assertEquals(500000, dealList.getPaymentsSum());
    }
}
