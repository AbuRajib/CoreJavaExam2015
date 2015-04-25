package com.Amazon;


import BaseApi.Base;
import org.testng.annotations.Test;

/**
 * Created by HP on 4/16/2015.
 */
public class SignUp extends Base{
    @Test
    public void signin() throws InterruptedException {
        clickBycss("#nav-tools #nav-link-yourAccount .nav-line-1");
        sleepFor(2);
        clickBycss(".nav-action-inner");
        sleepFor(4);
    }
}
