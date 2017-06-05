package io.rscale.training.company;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class SampleData implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(SampleData.class);

    private final CompanyRepository repository;

    @Autowired
    public SampleData(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    	logger.info("Started SampleData...");
    	add(new Company("Resilient Scale", new String[]{"Resilient Scale, Inc", "Resilient Scale Inc", "RScale"}, "https://rscale.io", "resilientscale"));
    	add(new Company("Cloud Foundry", new String[]{"Cloud Foundry Foundation", "CFF"}, "https://cloudfoundry.org", "cloudfoundry"));
        repository.findAll().forEach(company -> logger.info(company));
    }
    	
    private void add(Company company) throws Exception {
    	if (repository.findByNameIgnoreCase(company.getName()).isEmpty()) {
    		repository.save(company);
    	}
    }
    
}