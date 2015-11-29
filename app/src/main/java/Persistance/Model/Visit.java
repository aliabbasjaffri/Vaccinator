package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

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

    @Column(name = "Date")
    public String date;

    @Column(name = "NextDueDate")
    public String nextDueDate;

    @Column(name = "Comments")
    public String comments;

}
