package com.cgi.cf.demo.company;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "dev", "local", "test" })
public class SampleData implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(SampleData.class);

	private final CompanyRepository repository;

	@Autowired
	public SampleData(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		logger.debug("Started SampleData...");
		add(new Company("Pivotal", new String[] { "Pivotal Software, Inc", "Pivotal Software Inc", "Pivotal" },
				"https://pivotal.io/", "pivotal"));
		add(new Company("CGI", new String[] { "CGI", "CGI Nederland BV" }, "https://www.cginederland.nl", "cgi"));
		repository.findAll().forEach(company -> logger.debug(company));
	}

	private void add(Company company) throws Exception {
		if (repository.findByNameIgnoreCase(company.getName()).isEmpty()) {
			repository.save(company);
		}
	}

}