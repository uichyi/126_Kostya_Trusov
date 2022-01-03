package deal_list_tests;

import org.junit.*;

public class DealListTests extends Assert{
    @Test
    public void create_CreateEmptyDealList_ContractCountEqualsZero(){
        DealList dealList = DealList.create();
        assertEquals(0, dealList.getContractsCount());
    }


}
