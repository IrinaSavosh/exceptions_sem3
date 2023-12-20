import java.util.Calendar;
import java.util.Scanner;

public class UserInformationTwo {
    


    public String[] userData;
    int requiredLength = 6;
    int phoneNumberLength = 12;

    public String[] getUserData() {
        return userData;
    }

    public UserInformationTwo() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(
                        "Введите данные в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол (f/m)");
                String input = scanner.nextLine();

                userData = input.split(" ");
                if (userData.length < requiredLength) {
                    throw new ArrayException("Массив содержит меньше элементов, чем требуется");
                } else if (userData.length > requiredLength) {
                    throw new ArrayException("Массив содержит больше элементов, чем требуется");
                }

                try {
                    testGender(userData);
                } catch (Exception e) {
                    throw new ArrayException("Некоректно введен пол");
                }

                try {
                    dateVerification(userData);
                } catch (ArrayException e) {
                    throw new ArrayException(
                            "Введено неверное значение: ошибка формата введенния даты рождения. Пожалуйста, повторите ввод данных снова.");
                }

                try {
                    findTwelveDigitNumber(userData);
                } catch (ArrayException e) {
                    throw new ArrayException(
                            "Введено неверное значение: ошибка в количестве цифр в номере телефона. Пожалуйста, повторите ввод данных снова.");
                }

                break;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage() + " Пожалуйста, попробуйте снова.");
            }
        }
        scanner.close();

    }

    public static void findTwelveDigitNumber(String[] array) throws Exception {
        for (String s : array) {
            if (s.matches("\\d{12}")) {
                return;
            }
        }
        throw new Exception("Вы ввели неверно номер телефона");
    }

    private void testGender(String[] arr) throws Exception {

        for (int i = 0; i < arr.length; i++) {
            char g = arr[i].charAt(0);
            if (arr[i].length() == 1) {
                if (g == 'f') {
                    arr[i] = "female";
                } else if (g == 'm') {
                    arr[i] = "male";
                } else {
                    throw new Exception(
                            "Введено неверное значение: ошибка формата введенных данных. Пожалуйста, повторите ввод данных снова.");
                }
            }

        }
    }

    private void dateVerification(String[] arr) throws Exception {
        for (String s : arr) {
            try {
                String[] parts = s.split("\\."); // разбиваем строку по точке
                if (parts.length == 3) {
                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);
                    Calendar calendar = Calendar.getInstance();
                    int currentYear = calendar.get(Calendar.YEAR);
                    if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > currentYear) {

                        throw new Exception(" ");
                    }
                }
            } catch (Exception e) {

                throw new Exception(
                        "Введено неверное значение в дате рождения.");

            }
        }
    }

}
