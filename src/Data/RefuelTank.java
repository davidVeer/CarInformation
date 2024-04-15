package Data;

import Util.InformationType;

import java.time.LocalDate;

public class RefuelTank {

    private final int refuelNumber;

    private final LocalDate date;

    private final int odometer;

    private final double liters;

    private final double totalPrice;

    private int kilometersDriven;

    private final double literPrice;

    private double kilometersPerLiter;


    public RefuelTank(int refuelNumber, int odometer, double liters, double totalPrice, LocalDate date) {
        this.refuelNumber = refuelNumber;
        this.odometer = odometer;
        this.liters = liters;
        this.totalPrice = totalPrice;
        this.date = date;
        this.kilometersDriven = -1;
        this.kilometersPerLiter = -1.0;
        this.literPrice = calculateLiterPrice();
    }

    //calculations for unknown variables
    public double calculateLpkm() {
        return kilometersDriven / liters;
    }

    public double calculateLiterPrice() {
        return totalPrice / liters;
    }


    //setter for kilometers driven (which also sets kilometers per liters)
    public void setKilometersDriven(int kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
        this.kilometersPerLiter = calculateLpkm();
    }


    //getters for all data
    public int getRefuelNumber() {
        return refuelNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getLiters() {
        return liters;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getKilometersDriven() {
        return kilometersDriven;
    }

    public double getLiterPrice() {
        return literPrice;
    }

    public double getKilometersPerLiter() {
        return kilometersPerLiter;
    }

    // toString

    @Override
    public String toString() {
        return
                "\n" + this.refuelNumber + " : " + "\n" +
                        "date : " + this.date + "\n" +
                        "odometer : km " + this.odometer + "\n" +
                        "liters : l " + this.liters + "\n" +
                        "totalPrice : €" + this.totalPrice + "\n" +
                        "kilometersDriven : km " + this.kilometersDriven + "\n" +
                        "kilometers per liter : 1/" + this.kilometersPerLiter + "\n" +
                        "literPrice : €" + this.literPrice + "\n";
    }

    public double getType(InformationType wantedInformation) {
        switch (wantedInformation) {
            case LITERS:
                return this.liters;
            case REFUEL_PRICE:
                return this.totalPrice;
            case KILOMETERS_DRIVEN:
                return this.kilometersDriven;
            case LITER_PRICE:
                return this.literPrice;
            case KILOMETERS_PER_LITER:
                return this.kilometersPerLiter;
            case REFUEL_NUMBER:
                return this.refuelNumber;
        }
        return this.refuelNumber;
    }
}
