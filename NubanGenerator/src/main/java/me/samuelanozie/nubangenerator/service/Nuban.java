package me.samuelanozie.nubangenerator.service;

public class Nuban {
    public static String padNumber(String number, int length) {

        // add extra zeros to the left of the number
        while (number.length() < length) {
            number = "0" + number;
        }
        return number;
    }

    public static String generateNewNuban(String bankCode, String serialNumber) {
        String nubanNumber = "";
        String accountNumber = bankCode + serialNumber;

        //Algorthm: https://www.cbn.gov.ng/OUT/2011/CIRCULARS/BSPD/NUBAN%20PROPOSALS%20V%200%204-%2003%2009%202010.PDF
        int[] weights = {3,7,3,3,7,3,3,7,3,3,7,3};

        int sum = 0;

        for (int i = 0; i < accountNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(accountNumber.charAt(i))) * weights[i];
        }

        int checkDigit = 10 - (sum % 10);
        if (checkDigit == 10) {
            checkDigit = 0;
        }
        nubanNumber = serialNumber + checkDigit;


        return nubanNumber;
    }

}
