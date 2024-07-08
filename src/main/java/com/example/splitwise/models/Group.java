package com.example.splitwise.models;

import java.util.Date;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Group extends BaseModel{
    private String name;
    private String description;
    private Date createdAt;
}
