package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

/**
 * Created by aliabbasjaffri on 30/11/15.
 */
@Table(name = "VaccinatorInfo")
public class VaccinatorInfo extends Model
{
    @Column(name = "RegNumber")
    public String regNumber;

    @Column(name = "Name")
    public String name;

    @Column(name = "CNIC")
    public String cnic;

    @Column(name = "ContactNumber")
    public String contactNumber;

    @Column(name = "Gender")
    public String gender;

    @Column(name = "Address")
    public String address;

    @Column(name = "SupervisorID")
    public String supervisorID;

    @Column(name = "UCID")
    public String ucID;

    public VaccinatorInfo()
    {
        super();
    }

    public VaccinatorInfo(String regNumber, String name, String cnic, String contactNumber, String gender, String address, String supervisorID, String ucID)
    {
        super();

        this.regNumber = regNumber;
        this.name = name;
        this.cnic = cnic;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.address = address;
        this.supervisorID = supervisorID;
        this.ucID = ucID;
    }
}
