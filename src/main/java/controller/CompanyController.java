package controller;
import entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CompanyServicesInterface;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    @Autowired
    public CompanyServicesInterface comServices;

//    @Path("/Company")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    @GetMapping("/Company")
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> companyList = this.comServices.getAllCompany();

        if (companyList.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(companyList));
    }

    @Path("/Company/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Company> getMappingByIdClassification(@PathVariable("id") int id) {
        Company company = this.comServices.getCompanyById(id);

        if (company == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(company));
    }

    @PostMapping(value = "/Company", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Company> postCompany(@RequestBody Company company) {
        try {
            this.comServices.addCompany(company);
            return ResponseEntity.status(HttpStatus.CREATED).body(company);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}