public class MyString2 {
    private final char[] chars;

    // Конструктор
    public MyString2(char[] chars) {
        this.chars = new char[chars.length];
        System.arraycopy(chars, 0, this.chars, 0, chars.length);
    }

    // Возвращает подстроку начиная с указанного индекса
    public MyString2 substring(int begin) {
        if (begin < 0 || begin > chars.length) {
            throw new IndexOutOfBoundsException("Индекс " + begin + " за пределами строки");
        }
        char[] subChars = new char[chars.length - begin];
        System.arraycopy(chars, begin, subChars, 0, chars.length - begin);
        return new MyString2(subChars);
    }

    // Возвращает строку в верхнем регистре
    public MyString2 toUpperCase() {
        char[] upperChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            upperChars[i] = Character.toUpperCase(chars[i]);
        }
        return new MyString2(upperChars);
    }

    // Возвращает массив символов
    public char[] toChars() {
        char[] copy = new char[chars.length];
        System.arraycopy(chars, 0, copy, 0, chars.length);
        return copy;
    }

    // Преобразует boolean в строку
    public static MyString2 valueOf(boolean b) {
        return b ? new MyString2(new char[]{'t', 'r', 'u', 'e'})
                : new MyString2(new char[]{'f', 'a', 'l', 's', 'e'});
    }

    // Для удобного вывода
    @Override
    public String toString() {
        return new String(chars);
    }

    // Тестирование
    public static void main(String[] args) {
        System.out.println("=== Тестирование MyString2 ===");

        // Создаем тестовую строку
        MyString2 str = new MyString2("Программирование".toCharArray());
        System.out.println("Исходная строка: " + str);

        // Тест substring()
        System.out.println("\n1. Тест substring():");
        MyString2 subStr = str.substring(3);
        System.out.println("Подстрока с 3-го символа: " + subStr); // "граммирование"

        // Тест toUpperCase()
        System.out.println("\n2. Тест toUpperCase():");
        MyString2 upperStr = str.toUpperCase();
        System.out.println("Верхний регистр: " + upperStr); // "ПРОГРАММИРОВАНИЕ"

        // Тест toChars()
        System.out.println("\n3. Тест toChars():");
        char[] charArray = str.toChars();
        System.out.print("Массив символов: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }

        // Тест valueOf()
        System.out.println("\n\n4. Тест valueOf():");
        MyString2 trueStr = MyString2.valueOf(true);
        MyString2 falseStr = MyString2.valueOf(false);
        System.out.println("Значение true: " + trueStr);
        System.out.println("Значение false: " + falseStr);
    }
}