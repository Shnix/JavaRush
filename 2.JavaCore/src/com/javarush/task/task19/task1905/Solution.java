package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            Set<Map.Entry<String, String>> entrySet = countries.entrySet();
            String result="";
            Object desiredObject = customer.getCountryName();//что хотим найти
            for (Map.Entry<String, String> pair : entrySet) {
                if (desiredObject.equals(pair.getValue())) {
                    result = pair.getKey();// нашли наше значение и возвращаем  ключ
                }
            }
            return result;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();
            String[] name = fullName.split(", ");
            String hisName = name[1];
            return hisName;
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();
            String[] name = fullName.split(", ");
            String hisName = name[0];
            return hisName;
        }

        @Override
        public String getDialString() {
            StringBuilder sb = new StringBuilder();
            String s = contact.getPhoneNumber();
            sb.append("callto://+");
            for (int i = 0; i < s.length(); i++) {
                if (Character .isLetterOrDigit(s.charAt(i)))
                    sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}