package hexlet.code;

public class RandomUtils {
    public static final int DEFAULT_LOWER_BORDER = 0;
    public static final int DEFAULT_UPPER_BORDER = 100;

    public static int generateRandomNumber(int lowerBorder, int upperBorder) {
        return (int) (Math.random() * (upperBorder - lowerBorder + 1) + lowerBorder);
    }
}
