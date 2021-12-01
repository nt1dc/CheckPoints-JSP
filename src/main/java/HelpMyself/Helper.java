package HelpMyself;

import Model.Result;
import Model.Results;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Helper {
    private static final List<Double> rValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);

    public static double getDoubleParameter(String parameter) {
        return Double.parseDouble((parameter).replace(",", "."));
    }

    public static boolean checkDataValidation(double x, double y, double r) {
        if (rValues.contains(r) && (-2 < x && x < 2) && (-5 <= y && y <= 5)) {
            return true;
        }
        return false;
    }

    public static String getTable(Results results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Result result : results.entries) {
            stringBuilder.append( "<td>" + result.getX() + "</td><td>" + result.getY() + "</td><td>" + result.getR() + "</td><td>" + results.getSimpleDateFormat().format(result.getResultTime()) + "</td><td>" + result.getQueryTime()  + "</td><td>" + result.getResult() + "</td></tr>");
        }
        return stringBuilder.toString();
    }
}
