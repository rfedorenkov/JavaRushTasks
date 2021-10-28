package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        String fileContent = getUpdatedFileContent(vacancies);
        updateFile(fileContent);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {

        try {
            Document doc = getDocument();
            Elements templateHidden = doc.getElementsByClass("template");
            Element template = templateHidden.clone().removeAttr("style").removeClass("template").get(0);

            Elements prevVacancies = doc.getElementsByClass("vacancy");

            prevVacancies.stream()
                    .filter(redundant -> !redundant.hasClass("template"))
                    .forEach(Node::remove);

            vacancies.forEach(vacancy -> {
                Element element = template.clone();

                Element url = element.getElementsByAttribute("href").get(0);
                url.appendText(vacancy.getTitle());
                url.attr("href", vacancy.getUrl());

                Element city = element.getElementsByClass("city").get(0);
                city.appendText(vacancy.getCity());

                Element companyName = element.getElementsByClass("companyName").get(0);
                companyName.appendText(vacancy.getCompanyName());

                Element salary = element.getElementsByClass("salary").get(0);
                salary.appendText(vacancy.getSalary());

                templateHidden.before(element.outerHtml());
            });

            return doc.html();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }


    private void updateFile(String text) {
        try (FileWriter fis = new FileWriter(filePath)) {
            fis.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//3. Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
//В файле backup.html это одна вакансия - Junior Java Developer.
//Нужно удалить все теги tr, у которых class="vacancy".
//Но тег tr, у которого class="vacancy template", не удаляй.
//Используй метод remove.
//
//4. В цикле для каждой вакансии полученной как параметр метода:
//4.1. склонируй шаблон тега, полученного в п.2. Метод clone.
//4.2. получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
//4.3. получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
//4.4. получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
//4.5. получи элемент-ссылку с тегом a. Запиши в него название вакансии(title). Установи реальную ссылку на вакансию вместо href="url".
//4.6. добавь outerHtml элемента, в который ты записывал данные вакансии,
//непосредственно перед шаблоном <tr class="vacancy template" style="display: none">
//
//5. Верни html код всего документа в качестве результата работы метода.
//
//6. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".
//
//7. Запусти приложение, убедись, что все вакансии пишутся в файл vacancies.html.
//

//3. Получи элемент, у которого есть класс template. Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
//4. Удали из страницы все добавленные ранее вакансии с классом "vacancy". Элемент с классом "vacancy template" должен остаться.
//5. Перед объектом template для каждой вакансии добавь на страницу отдельный html-элемент, используя копию template. Верни html-код всей страницы в качестве результата работы метода.
//6. Для каждой вакансии должен быть корректно заполнен элемент-ссылка с названием вакансии(title) и http-ссылкой на нее(href).
//7. Для каждой вакансии должен быть корректно заполнен элемент с классом "city".
//8. Для каждой вакансии должен быть корректно заполнен элемент с классом "companyName".
//9. Для каждой вакансии должен быть корректно заполнен элемент с классом "salary".
//10. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".