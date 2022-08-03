package services;
import dao.CompanyRepo;
import entity.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

//@Service
@ApplicationScoped
public class CompanyServices implements CompanyServicesInterface
{
    //@Autowired
    @Inject
    private CompanyRepo comRepo;

    public List<Company> getAllCompany() {
        List<Company> com1 = (List<Company>) this.comRepo.findAll();
        return com1;
    }

    public Company getCompanyById(int id)
    {
        Company com2=null;
        com2=this.comRepo.findById(id);
        return com2;
    }

    public Company addCompany(Company com3)
    {
        return this.comRepo.save(com3);
    }

    public void deleteCompany(int id)
    {
        comRepo.deleteById(id);
    }

    public Company updateCompany(Company com4, int id)
    {
        Company com= new Company();
        com.setId(com4.getId());
        com.setCompanyName(com4.getCompanyName());
        com.setCompanyDesc(com4.getCompanyDesc());
        this.comRepo.save(com);
        return com;
    }
}
