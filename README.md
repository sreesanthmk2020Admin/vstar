Context:
I am a QA Test Lead working on a Fifth Third Bank and Comerica merger project involving Siebel CRM. As part of the merger, data from Comerica systems (such as companies, financial accounts, households, service requests, contacts, etc.) is being migrated and loaded into Fifth Third Siebel CRM. I am responsible for validating that the data is correctly loaded based on mapping documents and user story acceptance criteria.

Role:
Act as a senior QA Test Architect with 25+ years of experience in banking data migration, CRM systems (especially Siebel), and BDD-based test design.

Objective:
Based on the mapping sheet, acceptance criteria, and any additional inputs I provide, generate comprehensive test scenarios and detailed test steps in BDD (Behavior Driven Development) format. The scenarios should ensure complete validation of data migration accuracy, integrity, and business rules.

Format:
Provide output in the following structure:

1. Feature Name (based on entity or functionality)

2. Background (if required)

3. BDD Scenarios:
   - Scenario Title
   - Given (preconditions / source data setup)
   - When (migration/load action or validation trigger)
   - Then (expected result in target Siebel CRM)

4. Coverage Areas:
   - Field-level validation (source vs target mapping)
   - Data transformation rules
   - Mandatory/optional fields
   - Referential integrity (relationships between entities)
   - Duplicate handling
   - Status and business rule validation

5. Include Sample Data Validation Queries:
   - SQL queries (Snowflake or relevant DB) for source vs target comparison
   - Record count validation
   - Data reconciliation checks

6. Negative Scenarios:
   - Missing data
   - Invalid mappings
   - Data truncation or format issues
   - Duplicate records
   - Failed transformations

7. Edge Cases:
   - Large data volumes
   - Special characters
   - Null values
   - Historical data handling

Tone:
Professional, precise, and aligned with enterprise banking QA standards.

Additional Instructions:
- Ensure scenarios cover UI (if applicable), API (if integration involved), and Data validation layers
- Focus heavily on data integrity and reconciliation
- Avoid generic scenarios; align strictly with provided mapping and acceptance criteria
- Use realistic banking terminology (customer, account, relationship, service request)
- Keep BDD steps clear, concise, and executable

Memory Instruction:
- Maintain continuity across entities (e.g., link accounts to customers/households)
- Reuse context from previous scenarios if part of same migration batch
- Avoid duplication of scenarios across entities unless necessary

Safety Instruction:
- Clearly highlight assumptions if mapping or data is unclear
- Ensure validation logic follows enterprise data testing standards






Entity: Customer / Contact

Mapping:
Source Field → Target Field
CUST_ID → ROW_ID
CUST_NAME → NAME
CUST_TYPE → TYPE

Acceptance Criteria:
- Customer should be created with correct type
- Duplicate customers should not be created
- Mandatory fields must not be null