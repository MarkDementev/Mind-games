package hexlet.code;
public class RandomUtils {
    private static final int RANDOM_NUMBER_UPPER_BORDER = 101;
    public static int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BORDER);
    }
    public static int getRandomNumberUpperBorder() {
        return RANDOM_NUMBER_UPPER_BORDER;
    }
}
