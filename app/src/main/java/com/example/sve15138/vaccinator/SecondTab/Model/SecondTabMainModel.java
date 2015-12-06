package com.example.sve15138.vaccinator.SecondTab.Model;

/**
 * Created by aliabbasjaffri on 06/12/15.
 */
public class SecondTabMainModel
{
    private String childID;
    private String childName;
    private String fatherName;
    private String status;

    public SecondTabMainModel(String childID, String childName, String fatherName, String status)
    {
        this.childID = childID;
        this.childName = childName;
        this.fatherName = fatherName;
        this.status = status;
    }

    public String getChildID() {
        return childID;
    }

    public void setChildID(String childID) {
        this.childID = childID;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
