package com.ex.tsiganov.myconverter;

/**
 * Created by Tsiganov on 10.03.2016.
 */
public class Converter {
    double usdK;
    double eurK;
    double rubK;

    public Converter(double usd, double eur, double rub)
    {
        usdK = usd;
        eurK = eur;
        rubK = rub;
    }

    public double getEurK() { return eurK; }

    public double getRubK() { return rubK; }

    public double getUsdK() { return usdK; }

    public void setEurK(double eurK) { this.eurK = eurK; }

    public void setRubK(double rubK) { this.rubK = rubK; }

    public void setUsdK(double usdK) { this.usdK = usdK; }

    public double getGrnToUsd(double grn)
    {
        return grn / usdK;
    }

    public double getGrnToEur(double grn)
    {
        return grn / eurK;
    }

    public double getGrnToRub(double grn)
    {
        return grn / rubK;
    }

    public double getUsdToGrn(double usd)
    {
        return usd * usdK;
    }

    public double getEurToGrn(double eur)
    {
        return eur * usdK;
    }

    public double getRubToGrn(double rub)
    {
        return rub * usdK;
    }
}
