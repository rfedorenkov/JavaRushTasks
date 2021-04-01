package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Читаем и пишем в файл: JavaRush
 * Реализуй логику записи в файл и чтения из файла для класса JavaRush.
 * Метод main реализован только для тебя и не участвует в тестировании.
 *
 *
 * Требования:
 * 1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
 * 2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
 * 3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
 * 4. Класс Solution.JavaRush должен быть публичным.
 * 5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user : users) {
                StringBuilder sb = new StringBuilder();
                sb.append(user.getFirstName());
                sb.append("/");
                sb.append(user.getLastName());
                sb.append("/");
                sb.append(user.isMale());
                sb.append("/");
                sb.append(user.getCountry());
                sb.append("/");
                sb.append(user.getBirthDate().getTime());
                sb.append("/");
                writer.println(sb);
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                String[] data = reader.readLine().split("/");
                user.setFirstName(data[0]);
                user.setLastName(data[1]);
                user.setMale("true".equals(data[2]));
                user.setCountry(User.Country.valueOf(data[3]));

                long birthday = Long.parseLong(data[4]);
                user.setBirthDate(new Date(birthday));

                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
