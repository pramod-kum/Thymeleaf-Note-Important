package com.bmt.school.models;

import jakarta.persistence.*;

@Entity
@Table(name = "recent_activity")
public class RecentActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String image;
    private String date;

    public RecentActivityEntity() {
    }

    public RecentActivityEntity(Long id, String title, String description, String image, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
