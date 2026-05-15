import pandas as pd

# =========================
# Read Layout File
# =========================

layout_df = pd.read_excel("layout.xlsx")

layout = []

for _, row in layout_df.iterrows():

    layout.append({
        "column_name": row["Column Name"],
        "start": int(row["Start"]),
        "length": int(row["Length"])
    })

# =========================
# Read Expected Data
# =========================

expected_df = pd.read_excel("snowflake_extract.xlsx")

# =========================
# Read TXT File
# =========================

actual_records = []

with open("company_records.txt", "r") as file:

    for line in file:

        record = {}

        for col in layout:

            start = col["start"]
            end = start + col["length"]

            value = line[start:end].strip()

            record[col["column_name"]] = value

        actual_records.append(record)

# Convert actual txt records to dataframe
actual_df = pd.DataFrame(actual_records)

# =========================
# Compare Data
# =========================

for index in range(len(expected_df)):

    expected_row = expected_df.iloc[index]
    actual_row = actual_df.iloc[index]

    for column in expected_df.columns:

        expected_value = str(expected_row[column]).strip()
        actual_value = str(actual_row[column]).strip()

        if expected_value != actual_value:

            print("Mismatch Found")
            print(f"Row Number : {index + 1}")
            print(f"Column     : {column}")
            print(f"Expected   : {expected_value}")
            print(f"Actual     : {actual_value}")
            print("-------------------------")
=====



HIGH PRIORITY DEFECT SCENARIOS – SIEBEL CRM – COMERICA MERGER

1. Duplicate Company Creation
--------------------------------
Scenarios:
- ABC LLC vs ABC L.L.C
- ABC INC vs ABC Incorporated
- Case sensitivity differences
- Special character differences

Possible Defects:
- Duplicate organization records
- Multiple customer IDs
- Incorrect relationship mapping
- Duplicate statements/notices

------------------------------------------------------------

2. Contact Linked to Wrong Company
-----------------------------------
Scenario:
- Same contact name exists in multiple companies

Validation:
- Verify contact-org relationship
- Verify primary organization flag
- Verify position records

Possible Defects:
- Contact linked to wrong organization
- Old relationship overwritten
- Missing relationship history

------------------------------------------------------------

3. Address Survivorship Failure
--------------------------------
Scenario:
- Different addresses exist in Comerica and Fifth Third
- One address is newer, another marked primary

Validation:
- Verify correct address survives after merge

Possible Defects:
- Old address overwrites latest address
- Primary flag lost
- Multiple primary addresses

------------------------------------------------------------

4. Multiple Primary Address Flags
----------------------------------
Validation:
- Only one primary address should exist per customer/contact

Possible Defects:
- Multiple addresses marked Primary = Y
- UI shows inconsistent address
- APIs retrieve random address

------------------------------------------------------------

5. Contact Without Address
---------------------------
Scenario:
- Contact exists in source but address missing after migration

Possible Defects:
- Null foreign keys
- Failed address mapping
- Rejected ETL records

Impact:
- KYC issues
- Communication failures

------------------------------------------------------------

6. Shared Address Across Different Customers
---------------------------------------------
Scenario:
- Two unrelated customers linked to same address row

Possible Defects:
- Updating one customer updates another
- Shared address corruption

------------------------------------------------------------

7. Address Standardization Corruption
--------------------------------------
Test:
- Apartment numbers
- PO Box
- International addresses
- ZIP+4
- Special characters

Possible Defects:
- Address truncation
- ZIP removal
- Unicode corruption
- City/state mismatch

------------------------------------------------------------

8. Organization Hierarchy Breakage
-----------------------------------
Scenario:
- Parent-child company hierarchy migration

Validation:
- Parent org mapping
- Ultimate parent linkage

Possible Defects:
- Orphan subsidiaries
- Circular hierarchy
- Missing parent relationship

------------------------------------------------------------

9. Duplicate Contacts Due to Masking Logic
-------------------------------------------
Scenario:
- Different SSN/TIN masking formats

Possible Defects:
- Duplicate contact profiles
- Matching engine failure

------------------------------------------------------------

10. Historical Address Overwrite
---------------------------------
Scenario:
- Old snapshot loaded after latest incremental load

Validation:
- Verify latest address retained

Possible Defects:
- Current address replaced by historical address

------------------------------------------------------------

11. Invalid State/Country Code Mapping
---------------------------------------
Examples:
- TX
- Texas
- TEX

Possible Defects:
- Invalid LOV mapping
- Blank state fields
- Integration failures

------------------------------------------------------------

12. Inactive Records Becoming Active
-------------------------------------
Scenario:
- Inactive Comerica customer becomes active after migration

Possible Defects:
- Dormant users reactivated
- Compliance issues

------------------------------------------------------------

13. Relationship Manager Assignment Loss
-----------------------------------------
Validation:
- RM assignment
- Portfolio ownership
- Branch mapping

Possible Defects:
- Null RM
- Wrong branch ownership
- Queue assignment failures

------------------------------------------------------------

14. UI vs Database Mismatch
----------------------------
Scenario:
- Database updated correctly but UI shows old data

Possible Defects:
- Cache issues
- Search index lag
- Integration mismatch

------------------------------------------------------------

15. Searchability Issues
-------------------------
Validation:
- Search by:
  - Company Name
  - ZIP
  - Phone
  - Address
  - Tax ID

Possible Defects:
- Duplicate search results
- Missing records
- Partial indexing

------------------------------------------------------------

HIGH VALUE TEST DATA TO TARGET
--------------------------------
1. Customers existing in both banks
2. Customers with multiple addresses
3. Customers with multiple contacts
4. International addresses
5. Inactive/closed customers
6. Large commercial organizations
7. Recently updated customers

------------------------------------------------------------

HIGH PROBABILITY DEFECT AREAS
-------------------------------
P1:
- Duplicate companies
- Multiple primary addresses
- Wrong contact-company association
- Address survivorship issues

P2:
- LOV/state mapping issues
- Historical overwrite issues
- Search/index mismatch

------------------------------------------------------------

SQL VALIDATION IDEAS
----------------------
- Duplicate Tax IDs
- Multiple Primary Flags
- Null Address Foreign Keys
- Duplicate Organization Names
- Contacts linked to multiple active orgs
- Invalid LOV mappings

------------------------------------------------------------

MOST COMMON REAL PRODUCTION DEFECTS
------------------------------------
- Data survivorship failures
- Referential integrity issues
- Duplicate management failures
- Incremental load sequencing issues
- UI/DB inconsistencies
- Search indexing failures
- Downstream integration mismatches