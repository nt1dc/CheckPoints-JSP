package Model;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
    private double x;
    private double y;
    private double r;
    private String result;
    private double queryTime;
    private Date resultTime;

    public double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(double queryTime) {
        this.queryTime = queryTime;
    }

    public String getResult() {
        return result;
    }

    public Result() {
    }

    public Result(double x, double y, double r, String result, long queryTime, Date resultTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.queryTime =  (double) ((Math.round(System.nanoTime() - queryTime)*100))/1000000;
        this.resultTime = resultTime;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String isResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }
}
