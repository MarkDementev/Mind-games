package hexlet.code;
public class RandomUtils {
    public static final int DEFAULT_LOWER_BORDER = 0;
    public static final int DEFAULT_UPPER_BORDER = 100;
    //если у игры не указаны точные границы при генерации чисел - использую дефолтные, записал их выше
    //т.е., в обычной ситуации генерируеся число в диаазоне [0;100]
    //тем более, это имеет практический смысл при определении вероятности выпадения +, -, * в калькуляторе
    //т.к. вероятность их выпадения одниковая, я сравниваю случайное число из генератора с тремя равными диапазонами
    public static int generateRandomNumber(int lowerBorder, int upperBorder) {
        return (int) (Math.random() * (upperBorder - lowerBorder + 1) + lowerBorder);
    }
}
