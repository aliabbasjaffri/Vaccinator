package Persistance.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by aliabbasjaffri on 30/11/15.
 */
@Table(name = "VacinatorInfo")
public class VacinatorInfo extends Model
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
}
