package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.service.StatisticsService;

@RestController
@RequestMapping("/api")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/test-stats")
    public void StatisticTest() throws DocumentException {
        statisticsService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\savegame18/farms.xml");
    }
}
