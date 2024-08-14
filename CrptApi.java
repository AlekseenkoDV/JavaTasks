/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.alekseenko.testtaskonhh;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fif90
 */
public class CrptApi
{

    private static final String API_URL = "https://ismp.crpt.ru/api/v3/lk/documents/create";
    private HttpClient httpClient;
    private ObjectMapper objectMapper;
    private Semaphore semaphore;

    public CrptApi(TimeUnit unit, int requestLimit)
    {
        try
        {
            if (requestLimit < 0)
            {
                throw new IllegalArgumentException("Перменная requestLimit" + "(" + requestLimit + ")" + " не может быть отрицательной");
            }

            this.httpClient = HttpClient.newHttpClient();
            this.objectMapper = new ObjectMapper();
            this.semaphore = new Semaphore(requestLimit);
            schedulePermitReplenishment(unit, requestLimit);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * 0 - начальная задержка 1 - переодичесность
     *
     * Согласно парамету, который бел передан в timeUnit Например если в
     * timeUnit переданы секунды, то каждую секунду будет добавлять новое
     * разрешение для выполнения запросы.
     *
     *
     * @param timeUnit
     * @param requestLimit
     */
    private void schedulePermitReplenishment(TimeUnit timeUnit, int requestLimit)
    {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable()
        {
            @Override
            public void run()
            {
                semaphore.release(requestLimit - semaphore.availablePermits());
            }
        }, 0, 1, timeUnit);
    }

    /**
     * Не стал реализовывать класс, который содержит поля документа и
     *
     * @param doc
     * @param signature
     */
    public void createDocument(Object doc, String signature)
    {
        try
        {
            semaphore.acquire();

            String requestBody = objectMapper.writeValueAsString(doc);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", "application/json")
                    .header("Signature", signature)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200)
            {
                throw new Exception("Ошибка создания документа." + response.body());
            }

            semaphore.release();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

class Document
{

    private String participantInn;
    private String doc_id;
    private String doc_status;
    private String doc_type = "LP_ INTRODUCE_GOODS";
    private String importRequest = "true";
    private String owner_inn;
    private String producer_inn;
    private String production_date;
    private String production_type;
    private List<Product> products = new ArrayList<>();
    private String regDate;
    private String uituCode;

    public void addProduct(Product product)
    {
        products.add(product);
    }

    // какие-то геттеры и сеттеры
    //...
}

class Product
{

    private String certificate_document;
    private String certificate_document_date;
    private String certificate_document_number;
    private String owner_inn;
    private String producer_inn;
    private String production_date;
    private String tnved_code;
    private String uit_code;
    private String uitu_code;

    // какие-то геттеры и сеттеры
    //...
}
