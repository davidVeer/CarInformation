package Data;

import java.time.LocalDate;

public class RefuelTank {

    private int refuelNumber;

    private LocalDate date;

    private int odometer;

    private double liters;

    private double totalPrice;

    private int kilometersDriven;

    private double literPrice;

    private double kmpl;


    public RefuelTank(int refuelNumber, int odometer, double liters, double totalPrice, LocalDate date) {
        this.refuelNumber = refuelNumber;
        this.odometer = odometer;
        this.liters = liters;
        this.totalPrice = totalPrice;
        this.date = date;
        this.kilometersDriven = -1;
        this.kmpl = -1.0;
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
        this.kmpl = calculateLpkm();
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

    public double getKmpl() {
        return kmpl;
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
                        "kilometers per liter : 1/" + this.kmpl + "\n" +
                        "literPrice : €" + this.literPrice + "\n";
    }

    public double getType(InformationType wantedInformation) {
        switch (wantedInformation) {
            case LITERS:
                return this.liters;
            case TOTAL_PRICE:
                return this.totalPrice;
            case KILOMETERS_DRIVEN:
                return this.kilometersDriven;
            case LITER_PRICE:
                return this.literPrice;
            case KILOMETERS_PER_LITER:
                return this.kmpl;
            case REFUEL_NUMBER:
                return this.refuelNumber;
        }
        return this.refuelNumber;
    }
}
