package task3;
public class DivisionCalculator {
    
    public static double divide(double dividend, double divisor) throws CustomDivisionException {
        if (divisor == 0) {
            CustomDivisionException exception = new CustomDivisionException(
                "Попытка деления " + dividend + " на ноль"
            );
            ExceptionLogger.logException(exception);
            throw exception;
        }
        return dividend / divisor;
    }
}