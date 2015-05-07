package com.Amazon;

import BaseApi.Base;
import homeFeatures.AmazonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 4/12/2015.
 */
    @Test
public class AmazonHome extends AmazonBase{

    public void amazonOfhomepage() throws InterruptedException {
        System.out.println(driver.getCurrentUrl());
        typeAndEnterBycss("#twotabsearchtextbox", "book");
        sleepFor(4);
          List<String> list=getListofTextBycss("#nav-subnav .nav-a");
        displayText(list);
        for(int i=0;i<list.size();i++){
            clickBytext(list.get(i));    //click webElements on by one
        }

        sleepFor(2);
    }

}
