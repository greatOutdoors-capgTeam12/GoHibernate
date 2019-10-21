package com.capgemini.go.util;

import java.util.Calendar;
import java.util.List;

import com.capgemini.go.dao.RetailerInventoryDao;
import com.capgemini.go.entity.RetailerInventoryEntity;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        RetailerInventoryDao retInvDao = new RetailerInventoryDao();
        for (int i = 0 ; i < 3; i++) {
        	Calendar orderTimeStamp = Calendar.getInstance();
        	String uid = "cat1uin000" + Integer.toString(i+1);
        	RetailerInventoryEntity retInvEntity = new RetailerInventoryEntity("ret01", (byte)1, uid, orderTimeStamp, orderTimeStamp, null);
        	retInvDao.saveProductDetails(retInvEntity);
        }
        
        List < RetailerInventoryEntity > products = retInvDao.getAllProducts();
        products.forEach(s -> System.out.println(s.toString()));
    }
}