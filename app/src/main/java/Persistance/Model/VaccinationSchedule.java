package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

/**
 * Created by aliabbasjaffri on 30/11/15.
 */
@Table(name = "VaccinationSchedule")
public class VaccinationSchedule extends Model
{
    @Column(name = "ChildID")
    public String childID;

    @Column(name = "VisitNumber")
    public String visitNumber;

    @Column(name = "Vaccine1Name")
    public String vaccine1Name;

    @Column(name = "Vaccine2Name")
    public String vaccine2Name;

    @Column(name = "Vaccine3Name")
    public String vaccine3Name;

    @Column(name = "VaccinationStatus")
    public boolean vaccinationStatus;

    @Column(name = "Comments")
    public boolean comments;

    public VaccinationSchedule(String childID, String visitNumber, String vaccine1Name, String vaccine2Name, String vaccine3Name, boolean vaccinationStatus, boolean comments)
    {
        super();

        this.childID = childID;
        this.visitNumber = visitNumber;
        this.vaccine1Name = vaccine1Name;
        this.vaccine2Name = vaccine2Name;
        this.vaccine3Name = vaccine3Name;
        this.vaccinationStatus = vaccinationStatus;
        this.comments = comments;
    }
}
