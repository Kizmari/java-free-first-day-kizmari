package com.kizmari;

import java.util.Scanner;

public class Main {

    static String[] arrayWord = {"vacation", "sun", "sea", "summer"};


    public static void main(String[] args){

        int lengthArrayWord = arrayWord.length;
        // Выше. Выясняем сколько слов в массиве arrayWord.

        //Ниже. Выбираем в массиве слово для угадывания.
        int randomWord = (int) (Math.random() * lengthArrayWord);
        // Выше. Умножаем случайное число на количество элементов в массиве слов.

        String word = arrayWord[randomWord];
        // Выше. Присваиваем уже готовой переменной word случайное слово из массива.
        //System.out.println("Проверка. Вы ввели слово: " + word);
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Угадай слово");
            int lengthWord = word.length();
            // Выше. Выясняем сколько букв в слове.
            String maskWord = "-".repeat(lengthWord);
            // Выше. Повтори нам строку "-" по длинне lengthWord.
            System.out.println(maskWord);

            do {
                System.out.println("Введите букву");
                char c = input.next().charAt(0);
                // Выше. Считай со строки (input) первый символ.

                if (word.indexOf(c) >= 0) {
                    //Выше. Есть ли в слове (word) символ "с". "-1" числа нет, "не -1" число есть.
                    System.out.println("Удача");
                    for (char elem : word.toCharArray()) {
                        // Выше. Пройтись по списку элементов в word.
                        if (elem == c) {
                            /* Выше. Если элемент тот, который мы напечатали (то есть переменная "с"),
                            то выполняется метод replaceMaskLetter по перепечатыванию слова
                            с учетом открывшихся букв (выводятся буквы в замаскированном слове.
                            Неразгаданные буквы остаются "-"*/
                            maskWord = replaceMaskLetter(c, maskWord, word);
                            /* Выше. Подключаем к переменной maskWord метод replaceMaskLetter,
                            который мы написали ниже (по перепечатыванию слова с учетом открывшихся букв.*/
                        }
                    }
                    System.out.println(maskWord);
                } else {
                    System.out.println("Промах, поробуй еще раз");
                    System.out.println(maskWord);
                }
            } while (maskWord.contains("-"));
            // Выше. Пока в замаскированном слове (maskWord) содержится "-", повторяй этот цикл.
            System.out.println("Поздравляем ты выйграл");
        }

    }

       public static String replaceMaskLetter(char c, String maskWord, String word) {
        //Выше. Метод, который заменяет замаскированные символы.
            StringBuilder stringBuilder = new StringBuilder();
            /* Выше. Создаем еще одну переменную (возможно объект??) "stringBuilder",
            которая позволяет очень удобно создать строку.*/
            for (int i = 0; i < word.length(); i++) {
                // Выше. Пройтись в цикле по всему слову (переменная word).
                if (word.charAt(i) == c) {
                    // Выше. Если такой символ есть.
                    stringBuilder.append(c);
                    // Выше. То к stringBuilder добавляем символ (с).
                } else if (maskWord.charAt(i) != '-') {
                    // Выше. Если рассматриваемый символ не "-".
                    stringBuilder.append(maskWord.charAt(i));
                    //Выше. То продолжаем добавлять (переменная i).
                } else {
                    stringBuilder.append("-");
                    // Выше. Если новый введенный символ не тот, который в слове, то добавляем черточку
                }
            }
            return stringBuilder.toString();
        }

}
