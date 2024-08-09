package com.budgets.functions;
import java.util.HashMap;
import java.util.Map;

public class monthConverter {
    private static final Map<String, String> monthMap = new HashMap<>();

    static {
        // Initialize the monthMap in a static block
        monthMap.put("january", "01");
        monthMap.put("february", "02");
        monthMap.put("march", "03");
        monthMap.put("april", "04");
        monthMap.put("may", "05");
        monthMap.put("june", "06");
        monthMap.put("july", "07");
        monthMap.put("august", "08");
        monthMap.put("september", "09");
        monthMap.put("october", "10");
        monthMap.put("november", "11");
        monthMap.put("december", "12");
    }

    public static String monthToNumber(String month)
    {
        String monthNumber = monthMap.get(month);
        if (monthNumber != null) {
            return monthNumber;
        } else {
            return null;
        }
    }
}
