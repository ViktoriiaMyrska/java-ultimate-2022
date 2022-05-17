package com.vikmir.homework;

import com.vikmir.data.Accounts;
import com.vikmir.homework.HashTable;

import java.time.LocalDate;

public class DemoApp {
    public static void main(String[] args) {
        var accounts = Accounts.generateAccountList(10);
        var emailToBirthdayTable = new HashTable<String, LocalDate>();
        accounts.forEach(a -> emailToBirthdayTable.put(a.getEmail(), a.getBirthday()));
        emailToBirthdayTable.printTable();
    }
}

//    As a result, you should see something like this:
//        0: abigailferguson@mail.com:1989-05-19 -> faith.myers@yahoo.com:1950-01-22
//        1: sofia.riley@mail.com:2007-01-02
//        2: nguyen@gmail.com:1961-03-18 -> clemons@mail.com:1967-03-24
//        3:
//        4: ferrell@mail.com:1989-03-12
//        5:
//        6: pope@mail.com:1930-12-28
//        7:
//        8:
//        9: lamb@gmail.com:2014-12-16 -> samantha.baker@gmail.com:2001-04-03
//        10:
//        11:
//        12:
//        13:
//        14: stokes@yahoo.com:1965-01-01
//        15: