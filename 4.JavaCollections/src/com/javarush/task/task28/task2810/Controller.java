package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }

        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> vacancies = new LinkedList<>();
        for (Provider provider : providers) {
            List<Vacancy> javaVacancies = provider.getJavaVacancies("");
            vacancies.addAll(javaVacancies);
        }
        System.out.println(vacancies.size());
    }
}