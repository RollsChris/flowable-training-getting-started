package com.flowable.gsd.work.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.flowable.content.api.ContentItem;
import org.flowable.content.api.ContentService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowable.content.engine.impl.persistence.entity.ContentItemEntity;

@Service("passengerCheckInService")
public class PassengerCheckInService {
    @Autowired
    public RuntimeService runtimeService;
    @Autowired
    public ContentService contentService;


    public void CheckIn(ArrayList<ContentItemEntity> flowableContentItem) {

        ContentItemEntity contentItemEntity = flowableContentItem.get(0);

        System.out.println("Checking in passenger");
        System.out.println("Flowable Content Item: " + flowableContentItem.toString());
        ContentItem contentItem = contentService.createContentItemQuery().id(contentItemEntity.getId()).singleResult();
        // System.out.println("Flowable Content Item: " + contentItem.toString());



         try (Reader reader = new BufferedReader(new InputStreamReader(contentService.getContentItemData(contentItem.getId())))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column
                String firstName = csvRecord.get("FirstName");
                String lastName = csvRecord.get("LastName");
                String email = csvRecord.get("Email");
                String ticketId = csvRecord.get("TicketId");

                // Process the CSV data as needed
                ProcessInstance instance = runtimeService
                .createProcessInstanceBuilder()
                .processDefinitionKey("bookFlights")
                .variable("firstName", firstName)
                .variable("lastName", lastName)
                .variable("email", email)
                .variable("ticketId", ticketId)
                .start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}
