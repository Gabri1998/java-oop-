package enums;

import exceptions.InvalidEmployeeException;
import enums.*;

import java.util.Locale;

public enum Degree
{

    BSC(1.1) {
        @Override
        public String toString() {
            return "BSc";
        }
    },

    MSC(1.2) {
        @Override
        public String toString() {
            return "MSc";
        }
    },

    PHD(1.35) {
        @Override
        public String toString() {
            return "PhD";
        }
    };



    private final double payoutRate;
    /**
    Enum Constructor that takes a payoutRate
     */
    Degree(double payoutRate)
    {
        this.payoutRate = payoutRate;
    }

    /**
     This method returns the payout rate
     */
    public  double getPayoutRate()
    {
        double payout = this.payoutRate;
        return payout;
    }

    /**
    This method will return Degree , and throws an exception if the degree is not valid
     */
    public static Degree getDegree(String deg)  throws InvalidEmployeeException {
        String degree = deg.toLowerCase();
        switch(degree) {
            case "bsc":
                return BSC;
            case "msc":
                return MSC;
            case "phd":
                return PHD;
            default:
                throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_DEGREE);
        }
    }


}
