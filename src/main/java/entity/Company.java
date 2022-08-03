package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company{

    @Id
    @GeneratedValue
    private int id;
    private String companyName;
    private String companyDesc;

    public Company(int id, String companyName, String companyDesc) {
        this.id = id;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
    }

    public Company() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + companyName + '\'' +
                ", desc='" + companyDesc + '\'' +
                '}';
    }
}
