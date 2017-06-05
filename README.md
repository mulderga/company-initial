# company-initial

- First we remove logging to FILE (removed logback xml stuff)
- Added dev as active profile.
- Logging to STDOUT to Logger Framework.
- SampleData used System.out -> Logger.debug().
- Created Manifest DEV YAML.
- Created service DB: cf create-service cleardb spark company-db
- Added dependencies for Spring Cloud Foundry Connectors
- cf push the company jar using manifest and no-start
- Set active profile DEV


TODO: 
- fix test (!!!)