//package com.dmarchante.taskmaster;
//
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = TaskmasterApplication.class)
//@WebAppConfiguration
//@ActiveProfiles("local")
//public class TaskmasterApplicationRepositoryIntegrationTest {
//    private DynamoDBMapper dynamoDBMapper;
//
//    @Autowired
//    private AmazonDynamoDB amazonDynamoDB;
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    private static final String EXPECTED_DESCRIPTION = "Test Description";
//    private static final String EXPECTED_STATUS = "Test Status";
//    private static final String EXPECTED_TITLE = "Test Title";
//
//    @Before
//    public void setup() throws Exception {
//        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//
//        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Tasks.class);
//
//        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//
//        dynamoDBMapper.batchDelete(taskRepository.findAll());
//    }
//
//    @Test
//    public void readWriteTestCase() {
//        Tasks task = new Tasks(EXPECTED_DESCRIPTION, EXPECTED_STATUS, EXPECTED_TITLE);
//        taskRepository.save(task);
//
//        List<Tasks> result = (List<Tasks>) taskRepository.findAll();
//
//        assertTrue("Not empty", result.size() > 0);
//        assertEquals("Contains item with expected description", result.get(0).getDescription().toString(), EXPECTED_DESCRIPTION);
//        assertEquals("Contains item with expected status", result.get(0).getStatus().toString(), EXPECTED_STATUS);
//        assertEquals("Contains item with expected title", result.get(0).getTitle().toString(), EXPECTED_TITLE);
//
//    }
//}
