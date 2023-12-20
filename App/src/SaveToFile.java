import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

   public SaveToFile(String[] array) throws IOException {
if (array.length == 0) {
         System.out.println("Массив строк пуст.");
         return;
      }
   String lastName = array[0];
   String firstName = array[1];
   String middleName = array[2];
   String birthDate = array[3];
   String phoneNumber = array[4];
   String gender = array[5];
   FileWriter writer = new FileWriter(array[0] +".txt", true);
   writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate
   + " " + phoneNumber + " "
   + gender + "\n");
   writer.close();

   System.out.println("Данные успешно записаны в файл.");
   }
     
}
