package com.example.booking.entity;

public class Bookings {
    public String workspace_name;
    public int workspace_id;
    public String booking_date;

    public Bookings() {
    }

    public Bookings(String workspace_name, int workspace_id, String booking_date) {
        this.workspace_name = workspace_name;
        this.workspace_id = workspace_id;
        this.booking_date = booking_date;
    }

    public String getWorkspace_name() {
        return workspace_name;
    }

    public void setWorkspace_name(String workspace_name) {
        this.workspace_name = workspace_name;
    }

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "workspace_name='" + workspace_name + '\'' +
                ", workspace_id=" + workspace_id +
                ", booking_date='" + booking_date + '\'' +
                '}';
    }
}
