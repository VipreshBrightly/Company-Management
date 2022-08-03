package services;
import entity.Company;
import java.util.List;

public interface CompanyServicesInterface
{
    public List<Company> getAllCompany();

    public Company getCompanyById(int id);

    public Company addCompany(Company company1);

    public void deleteCompany(int id);

    public Company updateCompany(Company company1, int id);

}
