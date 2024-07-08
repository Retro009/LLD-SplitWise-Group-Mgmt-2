package com.example.splitwise.models;

import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GroupAdmin extends BaseModel{
    @ManyToOne
    private Group group;
    @ManyToOne
    private User admin;
    @ManyToOne
    private User addedBy;
}
