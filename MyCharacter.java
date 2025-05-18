public class MyCharacter {
    private final char value;

    // Конструктор
    public MyCharacter(char value) {
        this.value = value;
    }

    // Возвращает значение символа
    public char charValue() {
        return value;
    }

    // Сравнивает текущий символ с другим
    public int compareTo(MyCharacter other) {
        return this.value - other.value;
    }

    // Проверяет равенство символов
    public boolean equals(MyCharacter other) {
        if (this == other) return true;
        if (other == null) return false;
        return this.value == other.value;
    }

    // Проверяет, является ли символ цифрой (для объекта)
    public boolean isDigit() {
        return value >= '0' && value <= '9';
    }

    // Проверяет, является ли символ цифрой (статический метод)
    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // Проверяет, является ли символ буквой
    public static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // Проверяет, является ли символ буквой или цифрой
    public static boolean isLetterOrDigit(char ch) {
        return isLetter(ch) || isDigit(ch);
    }

    // Проверяет, является ли символ строчной буквой
    public static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    // Проверяет, является ли символ заглавной буквой
    public static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    // Преобразует символ в верхний регистр
    public static char toUpperCase(char ch) {
        if (isLowerCase(ch)) {
            return (char)(ch - 32);
        }
        return ch;
    }

    // Преобразует символ в нижний регистр
    public static char toLowerCase(char ch) {
        if (isUpperCase(ch)) {
            return (char)(ch + 32);
        }
        return ch;
    }

    // Тестирование
    public static void main(String[] args) {
        System.out.println("Тестирование MyCharacter");

        // Создаем тестовые символы
        MyCharacter charA = new MyCharacter('A');
        MyCharacter charB = new MyCharacter('b');
        MyCharacter char5 = new MyCharacter('5');

        // 1. Тест базовых методов
        System.out.println("\n1. Базовые методы:");
        System.out.println("charA: " + charA.charValue());
        System.out.println("charB: " + charB.charValue());
        System.out.println("Сравнение A и b: " + charA.compareTo(charB));
        System.out.println("Равенство A и A: " + charA.equals(new MyCharacter('A')));

        // 2. Тест методов проверки
        System.out.println("\n2. Проверка типа символа:");
        System.out.println("'5' - цифра? " + char5.isDigit());
        System.out.println("'@' - буква? " + MyCharacter.isLetter('@'));
        System.out.println("'C' - буква или цифра? " + MyCharacter.isLetterOrDigit('C'));

        // 3. Тест методов регистра
        System.out.println("\n3. Работа с регистром:");
        System.out.println("'k' - строчная? " + MyCharacter.isLowerCase('k'));
        System.out.println("'Z' - заглавная? " + MyCharacter.isUpperCase('Z'));
        System.out.println("'m' в верхнем регистре: " + MyCharacter.toUpperCase('m'));
        System.out.println("'N' в нижнем регистре: " + MyCharacter.toLowerCase('N'));
    }
}