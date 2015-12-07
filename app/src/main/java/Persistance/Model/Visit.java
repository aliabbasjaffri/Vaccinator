package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

/**
 * Created by aliabbasjaffri on 30/11/15.
 */
@Table(name = "Visit")
public class Visit extends Model
{
    @Column(name = "ChildID")
    public String childID;

    @Column(name = "VaccinatorID")
    public String vaccinatorID;

    @Column(name = "BHUID")
    public String bhuID;

    @Column(name = "UCID")
    public String ucID;

    @Column(name = "Location")
    public String location;

    @Column(name = "VisitNumber")
    public String visitNumber;

    @Column(name = "Vaccinations")
    public String vaccinations;

    @Column(name = "Date")
    public String date;

    @Column(name = "NextDueDate")
    public String nextDueDate;

    @Column(name = "Comments")
    public String comments;

    public Visit()
    {
        super();
    }

    public Visit(String childID, String vaccinatorID, String bhuID, String ucID, String location, String visitNumber , String vaccinations , String date, String nextDueDate, String comments)
    {
        super();

        this.childID = childID;
        this.vaccinatorID = vaccinatorID;
        this.bhuID = bhuID;
        this.ucID = ucID;
        this.location = location;
        this.visitNumber = visitNumber;
        this.vaccinations = vaccinations;
        this.date = date;
        this.nextDueDate = nextDueDate;
        this.comments = comments;
    }
}
