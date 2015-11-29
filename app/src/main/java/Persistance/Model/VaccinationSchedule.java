package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

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

}
