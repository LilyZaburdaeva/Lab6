public class MyString1 {
    private final char[] chars;

    // Конструктор
    public MyString1(char[] chars) {
        this.chars = new char[chars.length];
        System.arraycopy(chars, 0, this.chars, 0, chars.length);
    }

    // Возвращает символ по индексу
    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами строки");
        }
        return chars[index];
    }

public int length() {
    int length = 0;
    for (char c : chars) {
        length++;
    }
    return length;
}

    // Возвращает подстроку
    public MyString1 substring(int begin, int end) {
        if (begin < 0 || end > chars.length || begin > end) {
            throw new IndexOutOfBoundsException("Некорректные индексы подстроки");
        }
        char[] subChars = new char[end - begin];
        System.arraycopy(chars, begin, subChars, 0, end - begin);
        return new MyString1(subChars);
    }

    // Возвращает строку в нижнем регистре
    public MyString1 toLowerCase() {
        char[] lowerChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            lowerChars[i] = Character.toLowerCase(chars[i]);
        }
        return new MyString1(lowerChars);
    }

    // Преобразует число в строку
    public static MyString1 valueOf(int i) {
        if (i == 0) {
            return new MyString1(new char[]{'0'});
        }

        boolean isNegative = i < 0;
        int num = isNegative ? -i : i;

        int length = 0;
        for (int temp = num; temp > 0; temp /= 10) {
            length++;
        }
        if (isNegative) {
            length++;
        }

        char[] digits = new char[length];
        for (int j = length - 1; j >= (isNegative ? 1 : 0); j--) {
            digits[j] = (char) ('0' + (num % 10));
            num /= 10;
        }
        if (isNegative) {
            digits[0] = '-';
        }

        return new MyString1(digits);
    }

    // Возвращает массив символов
    public char[] toChars() {
        char[] copy = new char[chars.length];
        System.arraycopy(chars, 0, copy, 0, chars.length);
        return copy;
    }

    // Сравнивает строки
    public boolean equals(MyString1 obj) {
        if (obj == null || this.chars.length != obj.chars.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != obj.chars[i]) {
                return false;
            }
        }
        return true;
    }

    // Для удобного вывода
    @Override
    public String toString() {
        return new String(chars);
    }

    // Тестирование
    public static void main(String[] args) {
        System.out.println("Тестирование MyString1");

        // Создаем тестовую строку
        MyString1 str = new MyString1("Привет".toCharArray());
        System.out.println("Исходная строка: " + str);

        // Тест charAt()
        System.out.println("\n1. Тест charAt():");
        System.out.println("3-й символ: " + str.charAt(2)); // 'и'

        // Тест length()
        System.out.println("\n2. Тест length():");
        System.out.println("Длина строки: " + str.length()); // 6

        // Тест substring()
        System.out.println("\n3. Тест substring():");
        MyString1 subStr = str.substring(2, 5);
        System.out.println("Подстрока(2-5): " + subStr); // "иве"

        // Тест toLowerCase()
        System.out.println("\n4. Тест toLowerCase():");
        MyString1 lowerStr = str.toLowerCase();
        System.out.println("Нижний регистр: " + lowerStr); // "привет"

        // Тест valueOf()
        System.out.println("\n5. Тест valueOf():");
        MyString1 numStr1 = MyString1.valueOf(123);
        MyString1 numStr2 = MyString1.valueOf(-456);
        System.out.println("Число 123: " + numStr1);
        System.out.println("Число -456: " + numStr2);

        // Тест equals()
        System.out.println("\n6. Тест equals():");
        MyString1 str2 = new MyString1("Привет".toCharArray());
        MyString1 str3 = new MyString1("привет".toCharArray());
        System.out.println("Сравнение с \"Привет\": " + str.equals(str2)); // true
        System.out.println("Сравнение с \"привет\": " + str.equals(str3)); // false

        // Тест toChars()
        System.out.println("\n7. Тест toChars():");
        char[] chars = str.toChars();
        System.out.print("Массив символов: ");
        for (char c : chars) {
            System.out.print(c + " ");
        }
    }
}
