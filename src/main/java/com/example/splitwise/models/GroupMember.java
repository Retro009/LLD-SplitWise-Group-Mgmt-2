package com.example.splitwise.models;


import java.util.Date;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GroupMember extends BaseModel{
    @ManyToOne
    private Group group;
    @ManyToOne
    private User user;
    @ManyToOne
    private User addedBy;
    private Date addedAt;
}