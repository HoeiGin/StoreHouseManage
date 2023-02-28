package org.StoreManage;

public class unit {

    private int id = 0;
    private String name = "NONE";
    private String date = "1970-01-01";
    private int quan = 0;
    private String note = "NONE";

    public void setID(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public int getID() {
        return (this.id);
    }

    public String getName() {
        return (this.name);
    }

    public String getDate() {
        return (this.date);
    }

    public int getQuan() {
        return (this.quan);
    }

    public String getNote() {
        return (this.note);
    }

    public void Output() {
        System.out.println(this.id + '\t'
                         + this.name + '\t'
                         + this.date + '\t'
                         + this.quan + '\t'
                         + this.note);
    }
}
