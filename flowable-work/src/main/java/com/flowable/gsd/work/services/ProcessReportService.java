package com.flowable.gsd.work.services;

import java.util.Map;

import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessReportService {
    
    @Autowired
    HistoryService historyService;

    public void generateProcessReport(String processInstanceId) {
        HistoricProcessInstance historicProcessInstance  = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        

        Map<String,Object> variables = historicProcessInstance.getProcessVariables();

        variables.get("airportCode");
    }

}
