import BaseApi.Base;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 4/24/2015.
 */
public class ramdomApp extends Base {

    @Test
    public void getcellvalue(){
        String customername=getTextBycss("tbody tr:nth-child(2) td:nth-child(2)");
        String country=getTextBycss("tbody tr:nth-child(2) td:nth-child(7)");

        System.out.println(customername);
        System.out.println(country);

        List<String> lists=getListofTextBycss("tbody");
        displayText(lists);
    }
}
