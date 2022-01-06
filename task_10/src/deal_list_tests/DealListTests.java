package deal_list_tests;

import org.junit.*;
import deal_list_core.*;

import java.util.ArrayList;
import java.util.List;

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
        dealList.addContract("1", "20220104");
        dealList.addPaymentDocument(100000, 401,  PaymentDocumentType.PaymentOrder, "1", "20220104");
        assertEquals(1, dealList.getDeals().get("1").getPaymentDocumentsCount());
    }
    @Test
    public void getSum_GetSumOfAllPaymentsWithGivenNumber_SumEquals500000(){
        DealList dealList = DealList.create();
        dealList.addContract("1", "20220104");
        dealList.addPaymentDocument(100000, 401, PaymentDocumentType.PaymentOrder, "1", "20220104");
        dealList.addPaymentDocument(200000, 402, PaymentDocumentType.PaymentOrder, "1", "20220104");
        dealList.addPaymentDocument(200000, 403, PaymentDocumentType.BankOrder, "1", "20220104");
        assertEquals(500000, dealList.getDeals().get("1").getPaymentsSum());
    }
    @Test
    public void deletePayment_DeletePaymentWithGivenNumberOrderNumberAndDate_PaymentsCountEqualsZero(){
        DealList dealList = DealList.create();
        dealList.addContract("1","20220106");
        dealList.addPaymentDocument(100000, 404, PaymentDocumentType.BankOrder, "1", "20220107");
        dealList.deletePayment(404, "1", "20220107");
        assertEquals(0, dealList.getDeals().get("1").getPaymentDocumentsCount());
    }
    @Test
    public void deletePayment_DeletePaymentWithGivenNumberOrderNumberAndDate_PaymentsCountEqualsError(){
        DealList dealList = DealList.create();
        dealList.addContract("1","20220106");
        dealList.addPaymentDocument(100000, -1, PaymentDocumentType.BankOrder, "1", "20220107");
        dealList.deletePayment(404, "1", "20220107");
        assertEquals(0, dealList.getDeals().get("1").getPaymentDocumentsCount());
    }
    @Test
    public void getFull_GetFullListOfPayments_ListOfPayments(){
        DealList dealList = DealList.create();
        dealList.addContract("1","20220106");
        dealList.addPaymentDocument(700000, 405, PaymentDocumentType.PaymentOrder, "1", "20220107");
        dealList.addPaymentDocument(800000, 406, PaymentDocumentType.BankOrder, "1", "20220107");
        dealList.addPaymentDocument(1000000, 407, PaymentDocumentType.PaymentOrder, "1", "20220107");
        List<Integer> ListOfPayments = new ArrayList<>();
        ListOfPayments.add(700000);
        ListOfPayments.add(800000);
        ListOfPayments.add(1000000);
        assertArrayEquals(ListOfPayments.toArray(), dealList.getListOfPayments().toArray());
    }
}
