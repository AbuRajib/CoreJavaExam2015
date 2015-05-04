package com.Amazon;


import BaseApi.Base;
import homeFeatures.AmazonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utility.DataReader;

import java.io.IOException;

/**
 * Created by HP on 4/16/2015.
 */
public class SignUp extends AmazonBase{
    public DataReader dr=new DataReader();
    String path="Amazon\\data\\file1.xls";
    @Test
    public void signIn() throws InterruptedException, IOException {
        String[][] value=dr.fileReader(path);
        sleepFor(2);
        clickBycss("#nav-tools #nav-link-yourAccount .nav-line-1");
        clickBycss(".nav-action-inner");
        sleepFor(2);
        String emailLocator=value[1][0];
        String email=value[1][1];
        String passLocator=value[2][0];
        String pass=value[2][1];
        typeBycss(emailLocator, email);
        typeBycss(passLocator,pass);
        driver.findElement(By.id("signInSubmit-input")).sendKeys(Keys.ENTER);
        sleepFor(4);
    }
}
