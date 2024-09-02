package com.sitpass.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Facility facility;

    private int equipmentRating;
    private int staffRating;
    private int hygieneRating;
    private int roomRating;
    private String comment;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getEquipmentRating() {
        return equipmentRating;
    }

    public void setEquipmentRating(int equipmentRating) {
        this.equipmentRating = equipmentRating;
    }

    public int getStaffRating() {
        return staffRating;
    }

    public void setStaffRating(int staffRating) {
        this.staffRating = staffRating;
    }

    public int getHygieneRating() {
        return hygieneRating;
    }

    public void setHygieneRating(int hygieneRating) {
        this.hygieneRating = hygieneRating;
    }

    public int getRoomRating() {
        return roomRating;
    }

    public void setRoomRating(int roomRating) {
        this.roomRating = roomRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
