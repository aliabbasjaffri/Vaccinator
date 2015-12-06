package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

/**
 * Created by aliabbasjaffri on 29/11/15.
 */
@Table(name = "BabyInfo")
public class BabyInfo extends Model
{
    @Column(name = "ChildID")
    public String childID;

    @Column(name = "ChildName")
    public String childName;

    @Column(name = "ChildDOB")
    public String childDOB;

    @Column(name = "ChildGender")
    public boolean childGender;

    @Column(name = "FatherCNIC")
    public String fatherCNIC;

    @Column(name = "FatherName")
    public String fatherName;

    @Column(name = "ContactNumber")
    public String contactNumber;

    @Column(name = "Address")
    public String address;

    @Column(name = "District")
    public String district;

    @Column(name = "Tehsil")
    public String tehsil;

    @Column(name = "VisitNumber")
    public int visitNumber;

    @Column(name = "NextDueDate")
    public String nextDueDate;

    @Column(name = "UC")
    public String uC;

    @Column(name = "UpdateFlag")
    public boolean updateFlag;

    public BabyInfo()
    {
        super();
    }

    public BabyInfo(String childID, String childName, String childDOB, boolean childGender, String fatherCNIC, String fatherName, String contactNumber, String address, String district, String tehsil)
    {
        super();

        this.childID = childID;
        this.childName = childName;
        this.childDOB = childDOB;
        this.childGender = childGender;
        this.fatherCNIC = fatherCNIC;
        this.fatherName = fatherName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.district = district;
        this.tehsil = tehsil;
    }
}
