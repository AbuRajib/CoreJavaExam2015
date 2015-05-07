package com.Amazon;

import homeFeatures.AmazonBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 4/30/2015.
 */
public class Search extends AmazonBase{

    @Test

    public void searchIteams() throws InterruptedException {
//        setItems(AmazonBase.list);
//        getItems();

        List<String> listMenu=getListofTextBycss("#searchDropdownBox option");
//        Assert.assertEquals(listMenu,AmazonBase.menu);
        displayText(listMenu);

        for(String item:listMenu){
            typeAndEnterBycss("#twotabsearchtextbox",item);
            sleepFor(4);
        }
    }



}
