package hexlet.code;
public class RandomUtils {
    public static final int RANDOM_NUMBER_UPPER_BORDER = 101;
    public static int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BORDER);
    }
}
