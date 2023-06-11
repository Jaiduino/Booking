package com.example.booking.entity;

public class Slots {
   private int slot_id;
   private String slot_name;
   private boolean slot_active ;

    public Slots() {
    }

    public Slots(int slot_id, String slot_name, boolean slot_active) {
        this.slot_id = slot_id;
        this.slot_name = slot_name;
        this.slot_active = slot_active;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getSlot_name() {
        return slot_name;
    }

    public void setSlot_name(String slot_name) {
        this.slot_name = slot_name;
    }

    public boolean isSlot_active() {
        return slot_active;
    }

    public void setSlot_active(boolean slot_active) {
        this.slot_active = slot_active;
    }

    @Override
    public String toString() {
        return "Slots{" +
                "slot_id=" + slot_id +
                ", slot_name='" + slot_name + '\'' +
                ", slot_active=" + slot_active +
                '}';
    }
}
