package enums;

import exceptions.InvalidEmployeeException;



public enum GPA {
    HIGH(1, 1000),
    MEDIUM(1, 0),
    LOW(0, 0);



    private final double payoutRate;
    private final double bonus;

    GPA(double rate, double bonus) {
        this.payoutRate = rate;
        this.bonus = bonus;
    }

    public double getPAYOUT_RATE() {
        return this.payoutRate;
    }

    public double getBONUS() {
        return this.bonus;
    }


    public static GPA getGPA(int val) throws InvalidEmployeeException {
        if(val < 0 || val > 10) {
            throw new InvalidEmployeeException(val);
        } else if(val < 6) {
            return LOW;
        } else if(val < 8) {
            return MEDIUM;
        } else {
            return HIGH;
        }
    }
}
