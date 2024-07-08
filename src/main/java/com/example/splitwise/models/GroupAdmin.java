package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
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
