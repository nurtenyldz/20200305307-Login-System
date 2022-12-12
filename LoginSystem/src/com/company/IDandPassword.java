package com.company;

import java.util.HashMap;


public class IDandPassword {
    // generic collection - Map
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPassword(){
        logininfo.put("Nurten", "12345");
        logininfo.put("Yıldız", "abc123");
        logininfo.put("Username", "abc456");

    }


    protected HashMap getLoginInfo(){
        return logininfo;
    }

}