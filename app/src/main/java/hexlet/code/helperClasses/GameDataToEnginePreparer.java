package hexlet.code.helperClasses;

import hexlet.code.Engine;
import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

//Данный класс появился как компромисс между твоим указанием в переписке о том, что в Engine д.б. только один метод
//и требованиями Code Climate убрать Duplication.
//Также ты уже советовал создать один вспомогательный класс - RandomUtils, потому решил создать ещё один.
//Ведь каждая игра формирует вопросы и ответы, передавая их вместе со своим правилом в Engine.
//Т.е., каждая игра делает общие действия, но только вопросы/ответы формирует по-разному.
//Оставить общую для каждой игры логику в игре = разозлить Code Climate.
//Отправить в метод в Engine = "раздуть" этот единственный метод. Создать дополнительный метод в Engine я не могу.
//Потому создал этот дополнительный класс-преобразователь.
//Игры формируют пары вопросов и ответов, а этот класс преобразует их в удобные для обработки массивы.
//Они отправляются в Engine, который получился очень компактным благодаря пред-обработке вопросов/ответов.
//В итоге:
//1) App позволяет выбрать игру.
//2) Вопросы/ответы формируют именно игры, не этот новый метод. Игры же передают своё правило.
//3) Общая для игр логика подготовки массивов вопросов и ответов выделена в этот отдельный класс с одним методом.
//4) Engine ничего не знает про игры, получает данные "снаружи", имеет только один метод.
//5) Используя полученные извне данные, успешно доводит игрока до победы/поражения.

public class GameDataToEnginePreparer {
    public static void formQuestionsAnswersThenRunEngine(String gameType, String gameRule) {
        String[] gameQuestions = new String[Engine.ROUND_COUNT];
        String[] gameAnswers = new String[Engine.ROUND_COUNT];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            switch (gameType) {
                case "Even" -> {
                    gameQuestions[i] = Even.generateEvenQuestion();
                    gameAnswers[i] = Even.generateEvenCorrectAnswer(gameQuestions[i]);
                }
                case "Calculator" -> {
                    gameQuestions[i] = Calculator.generateCalculatorQuestion();
                    gameAnswers[i] = Calculator.generateCalculatorCorrectAnswer(gameQuestions[i]);
                }
                case "GCD" -> {
                    gameQuestions[i] = GCD.generateGCDQuestion();
                    gameAnswers[i] = GCD.generateGCDCorrectAnswer(gameQuestions[i]);
                }
                case "Progression" -> {
                    gameQuestions[i] = Progression.generateProgressionQuestion();
                    gameAnswers[i] = Progression.generateProgressionCorrectAnswer(gameQuestions[i]);
                }
                default -> {
                    gameQuestions[i] = Prime.generatePrimeQuestion();
                    gameAnswers[i] = Prime.generatePrimeCorrectAnswer(gameQuestions[i]);
                }
            }
        }
        Engine.runGame(gameRule, gameQuestions, gameAnswers);
    }
}
