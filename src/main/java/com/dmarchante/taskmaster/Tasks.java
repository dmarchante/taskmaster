package com.dmarchante.taskmaster;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

@DynamoDBTable(tableName = "cdmarch-taskmaster")
public class Tasks {
    private UUID id;
    private String assignee;
    private String description;
    private String pic;
    private String status = "Available";
    private String title;

    public Tasks() {};

    public Tasks(String assignee, String description, String pic, String status, String title) {
        this.assignee = assignee;
        this.description = description;
        this.pic = pic;
        this.status = status;
        this.title = title;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public UUID getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getAssignee() { return assignee; }

    @DynamoDBAttribute
    public String getDescription() { return description; }

    @DynamoDBAttribute
    public String getPic() { return pic; }

    @DynamoDBAttribute
    public String getStatus() { return status; }

    @DynamoDBAttribute
    public String getTitle() { return title; }

    public void setId(UUID id) { this.id = id; }

    public void setDescription(String description) { this.description = description; }

    public void setPic(String pic) { this.pic = pic; }

    public void setStatus(String status) { this.status = status; }

    public void setTitle(String title) { this.title = title; }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
        this.setStatus("Assigned");
    }
}
