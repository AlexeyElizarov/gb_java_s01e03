import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) {

        int ok_code = 1;
        Scanner scanner = new Scanner(System.in);

        print("Коллекция игр \"Борода Елизарова\"");

        while (ok_code == 1) {
            print("\n\n1 - Угадай число");
            print("\n2 - Угадай слово");
            print("\n0 - Выход");
            print("\n\nВыберите игру: ");

            ok_code = scanner.nextInt();

            switch (ok_code) {
                case 1:
                    guessNumberMain();
                    break;
                case 2:
                    guessWordMain();
            }
        }

    }

    private static void guessWordMain() {
        // Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        // apple – загаданное
        // apricot - ответ игрока
        // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        // Для сравнения двух слов посимвольно, можно пользоваться:
        // String str = "apple";
        // str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        // Играем до тех пор, пока игрок не отгадает слово
        // Используем только маленькие буквы

        int ok_code = 1;

        print("Угадайте слово.\n");

        while (ok_code == 1) {
            ok_code = guessWord();
        }
    }

    private static int guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        String guess = "";
        Scanner scanner = new Scanner(System.in);
        int mask_length = 15;
        String mask = "#";
        int check_length;
        String letter;

        while (!word.equals(guess)) {
            print("\nВведите слово: ");
            guess = scanner.next().toLowerCase();
            check_length = min(guess.length(), word.length());

            for (int i = 0; i < mask_length; i++) {
                letter = mask;
                if (i < check_length) {
                    if (guess.charAt(i) == word.charAt(i)) {
                        letter = Character.toString((word.charAt(i)));
                    }
                }
                print(letter);
                }
            print("\n");
            }

            print("\nВы угадали.");


        return 0;
    }

    private static void guessNumberMain() {
        // Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        int ok_code = 1;

        print("Угадайте число от 0 до 9.\n");

        while (ok_code == 1) {
            ok_code = guessNumber();
        }
    }

    private static int guessNumber() {
        int tries = 3;
        Random random = new Random();
        int number = random.nextInt(10);
        int guess;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tries; i++) {

            print(String.format("\n\nПопытка %s.", i + 1));
            print("\nВведите число: ");
            guess = scanner.nextInt();

            if (guess == number) {
                print("Вы угадали.");
                break;
            }
            else if (guess < number) {
                print("Загаданное число больше.");
            }
            else {
                print("Загаданное число меньше.");
            }

            if (i == tries - 1) {
                print("\nВы не угадали.");
            }
            }

        print("\n\nПовторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет): ");
        return scanner.nextInt();
        }

    private static void print(String s) {
        System.out.print(s);
    }
}


