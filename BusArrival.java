package MMN15;




/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  Time1
 */
public class BusArrival {
    private int _lineNumber;
    private Time1 _arrivalTime;
    private int _noOfPassengers;
    private final int MIN_LINE_NUM = 1;
    private final int MAX_LINE_NUM = 99;
    private final int MIN_NUM_OF_PASSENGERS = 0;
    private final int MAX_NUM_OF_PASSENGERS = 70;

    public BusArrival(int lineNum, int pass, int h, int m, int s) {
        this._lineNumber = 1;
        if (lineNum > 1 && lineNum <= 99) {
            this._lineNumber = lineNum;
        }
        this._noOfPassengers = 0;
        if (pass > 0 && pass <= 70) {
            this._noOfPassengers = pass;
        }
        this._arrivalTime = new Time1(h, m, s);
    }

    public BusArrival(int lineNum, int pass, Time1 t) {
        this._lineNumber = 1;
        if (lineNum > 1 && lineNum <= 99) {
            this._lineNumber = lineNum;
        }
        this._noOfPassengers = 0;
        if (pass > 0 && pass <= 70) {
            this._noOfPassengers = pass;
        }
        this._arrivalTime = new Time1(t);
    }

    public BusArrival(BusArrival other) {
        this._lineNumber = other._lineNumber;
        this._noOfPassengers = other._noOfPassengers;
        this._arrivalTime = new Time1(other._arrivalTime);
    }

    public Time1 getArrivalTime() {
        return new Time1(this._arrivalTime);
    }

    public int getLineNum() {
        return this._lineNumber;
    }

    public int getNoOfPass() {
        return this._noOfPassengers;
    }

    public void setArrivalTime(Time1 t) {
        this._arrivalTime = new Time1(t);
    }

    public void setLineNum(int num) {
        if (num >= 1 && num <= 99) {
            this._lineNumber = num;
        }
    }

    public void setNoOfPass(int num) {
        if (num >= 0 && num <= 70) {
            this._noOfPassengers = num;
        }
    }

    public boolean equals(BusArrival other) {
        return other != null && this._lineNumber == other._lineNumber && this._noOfPassengers == other._noOfPassengers && this._arrivalTime.equals(other._arrivalTime);
    }

    public String toString() {
        return "Bus no. " + this._lineNumber + " arrived at " + (Object)this._arrivalTime + " with " + this._noOfPassengers + " passengers";
    }

    public boolean fuller(BusArrival other) {
        return this._noOfPassengers > other._noOfPassengers;
    }

    public boolean before(BusArrival other) {
        return this._arrivalTime.before(other._arrivalTime);
    }

    public boolean isFull() {
        return this._noOfPassengers == 70;
    }

    public int elapsedTime(BusArrival other) {
        if (this.before(other)) {
            return other._arrivalTime.difference(this._arrivalTime) / 60;
        }
        if (this._arrivalTime.after(other._arrivalTime)) {
            return this._arrivalTime.difference(other._arrivalTime) / 60;
        }
        return 0;
    }
    
    
}
