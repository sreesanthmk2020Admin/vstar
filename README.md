
Subject: Request for ECIF File – CRM PreProd Validation (US 11122)

Hi Team,

As part of regression testing for User Story 11122, we need the ECIF file to validate the data in CRM PreProd. Could you please let us know if you’re able to provide the ECIF file at the earliest?

Thanks in advance for your support.

Best regards,
[Your Name]
-----------



5-Day CRM KT Plan (30 mins/day)

Day 1 – CRM Basics & Business Context

Goal: Help them understand what CRM is and why it exists.

Topics:
	•	What is CRM? (Customer, relationship, lifecycle)
	•	Why banks use CRM
	•	High-level banking flow:
	•	Customer → Account → Service Request
	•	Difference between:
	•	Customer vs Account
	•	Front office vs Back office
	•	Where CRM fits in the overall system landscape

Outcome:
They should be able to explain “What does a CRM system do in a bank?”

⸻

Day 2 – CRM Modules Overview

Goal: Familiarize them with what modules exist.

Topics:
	•	Core CRM entities:
	•	Contacts
	•	Companies / Households
	•	Accounts
	•	Service Requests (SR)
	•	How modules are linked
	•	Example flow:
	•	Customer raises issue → SR created → backend processing
	•	Simple real-life examples (ATM issue, address change, etc.)

Outcome:
They should understand how data flows between CRM modules.

⸻

Day 3 – CRM UI & Navigation

Goal: Make them comfortable with the CRM UI.

Topics:
	•	CRM UI structure:
	•	Screens
	•	Views
	•	Applets
	•	List View vs Form View
	•	How users search/query records
	•	Creating vs updating a record
	•	What is an LOV (List of Values)

Outcome:
They should be able to navigate CRM confidently without fear.

⸻

Day 4 – CRM Testing Fundamentals

Goal: Introduce QA thinking in CRM context.

Topics:
	•	What QA validates in CRM:
	•	UI
	•	Data
	•	Business rules
	•	Types of testing:
	•	Functional
	•	Regression
	•	Sanity
	•	What is a defect?
	•	How to observe and report issues clearly
	•	Simple examples of:
	•	UI defect
	•	Data defect
	•	LOV defect

Outcome:
They should understand how QA adds value in CRM projects.

⸻

Day 5 – End-to-End Flow + Expectations

Goal: Connect everything together and set expectations.

Topics:
	•	End-to-end example:
	•	Data created → backend job → data reflected in UI
	•	What is a job / batch / bubble-up (high level)
	•	How QA collaborates with:
	•	Dev
	•	Data
	•	PO
	•	Expectations from a junior QA:
	•	Observing carefully
	•	Asking questions
	•	Documenting clearly

Outcome:
They should have a big-picture understanding of the CRM QA role.

⸻

KT Style Tips (Very Important)
	•	Use simple language (avoid jargon initially).
	•	Ask 2–3 questions each day to check understanding.
	•	Encourage them to repeat concepts in their own words.
	•	Avoid automation/tools in the first week.

⸻

Optional Follow-Up (Week 2)
	•	Sit with you during:
	•	Defect validation
	•	Regression execution
	•	Test case review
	•	Slowly introduce:
	•	Test cases
	•	Jira
	•	CRM-specific terminology

⸻

If you want, I can:
	•	Convert this into a KT slide deck outline
	•	Create a daily KT checklist
	•	Draft a junior QA learning roadmap for 90 days


CRM Knowledge Transfer (KT) Document

Project: Fifth Third Bank – CRM
Audience: New QA Joiner (Fresher)
KT Duration: 5 Days (30 minutes/day)
Prepared by: [Your Name]

⸻

1. Introduction to CRM in Fifth Third Bank

1.1 What is CRM?

CRM (Customer Relationship Management) is a system used by Fifth Third Bank to:
	•	Maintain customer and account information
	•	Track customer interactions
	•	Manage service requests and issues
	•	Support banking operations and compliance

CRM acts as a single source of truth for customer-related data.

⸻

2. CRM Architecture – High-Level View

2.1 Systems Interaction
	•	CRM (Siebel) – Front-end user application
	•	Backend Systems – Core banking, data warehouse, external apps
	•	Batch / Sequence Jobs – Sync data between backend and CRM UI
	•	ACE / Other Apps – Integrations that consume or push data to CRM

CRM UI does not always update immediately—many changes happen through backend jobs.

⸻

3. Core CRM Entities (Used in Fifth Third Bank)

3.1 Contacts
	•	Represents an individual customer
	•	Contains personal information:
	•	Name
	•	Phone number
	•	Address
	•	Email
	•	A Contact can be linked to:
	•	Accounts
	•	Companies / Households
	•	Service Requests

⸻

3.2 Companies / Households
	•	Represents:
	•	Business customers (Company)
	•	Group of related individuals (Household)
	•	Used for:
	•	Relationship mapping
	•	Aggregated views of customers

⸻

3.3 Accounts
	•	Represents banking products:
	•	Savings
	•	Checking
	•	Loan
	•	Linked to Contacts or Companies
	•	Often populated via backend feeds

⸻

3.4 Service Requests (SR)
	•	Used to track customer issues such as:
	•	ATM issues
	•	Address updates
	•	Account inquiries
	•	SR Lifecycle:
	•	Created → Assigned → Worked → Closed

⸻

4. CRM UI Structure (Very Important)

4.1 Screens

Top-level navigation (e.g., Contacts, Accounts, Service Requests)

4.2 Views

Different layouts under a screen
Example: List View, Detail View

4.3 Applets

Small UI components inside a view:
	•	List Applet (multiple records)
	•	Form Applet (single record)

4.4 List View vs Form View
	•	List View: Shows multiple records (columns)
	•	Form View: Shows detailed data of one record

⸻

5. Key CRM Functionalities

5.1 Query & Search
	•	Used to find records using filters
	•	LOVs (List of Values) help standardize values

5.2 LOV (List of Values)
	•	Predefined value list used in:
	•	Dropdowns
	•	Column headers
	•	Must display correctly (common defect area)

⸻

5.3 Backend Jobs / Bubble-Up
	•	Backend jobs update CRM UI
	•	Example:
	•	Data created in DB → Job runs → Data appears in UI
	•	QA validates:
	•	Backend data
	•	UI reflection

⸻

5.4 Match-Merge
	•	Identifies duplicate records
	•	Matches based on:
	•	Name
	•	Phone
	•	Address
	•	Merges records into one

⸻

6. QA Role in CRM

6.1 What QA Validates
	•	UI correctness
	•	Data accuracy
	•	LOV behavior
	•	Job results
	•	Regression stability

6.2 Types of Testing
	•	Functional Testing
	•	Regression Testing
	•	Sanity Testing
	•	PreProd / Bubble-Up Testing

⸻

7. Common Defect Types
	•	Missing LOV values
	•	Incorrect UI column headers
	•	Data mismatch between backend and UI
	•	Checkbox behavior (Y/N vs Checked)
	•	Performance delays after fixes

⸻

8. Tools Used
	•	CRM Application (Siebel)
	•	JIRA / Digital.ai (defect & story tracking)
	•	Shared Drive (evidence)
	•	Excel (test data & trackers)
	•	Automation tools (future phase)

⸻

CRM KT CHECKLIST (Daily Use)

Day 1 – CRM Basics

☐ Explained what CRM is
☐ Explained why banks use CRM
☐ Explained customer lifecycle

⸻

Day 2 – CRM Entities

☐ Contacts explained
☐ Companies/Households explained
☐ Accounts explained
☐ SR lifecycle explained

⸻

Day 3 – CRM UI

☐ Screens vs Views explained
☐ Applets explained
☐ List View vs Form View explained
☐ Query and LOV explained

⸻

Day 4 – CRM Testing

☐ QA role explained
☐ Types of testing explained
☐ Defect examples shared
☐ How to observe issues explained

⸻

Day 5 – End-to-End Flow

☐ Backend job concept explained
☐ Bubble-up testing explained
☐ Match-merge explained
☐ Expectations from junior QA explained

⸻

KT Completion Criteria

☐ Can navigate CRM independently
☐ Can explain CRM entities
☐ Can identify basic defects
☐ Can follow testing instructions

⸻

Next Steps After KT
	•	Shadow senior QA
	•	Review test cases
	•	Learn defect logging
	•	Gradually move to execution

⸻

✅ If you want next:
	•	A printable PDF
	•	A PowerPoint KT deck
	•	A 30-60-90 day learning plan
	•	A CRM glossary for freshers

Just tell me what you want next.


================

practical, not academic.

⸻

🧭 Overall Learning Roadmap (QA-Focused)

Duration: ~12 weeks
Time: 1 hour/day, Monday–Friday
Outcome:
	•	Write clean Python code
	•	Automate UI + API tests
	•	Work with files, JSON, DB
	•	Crack Python QA interview questions

⸻

🗓️ Phase-wise Plan

🔹 Phase 1: Python Fundamentals (Weeks 1–3)

Goal: Think in Python

	•	Variables & data types
	•	Strings, numbers, booleans
	•	Lists, tuples, sets, dictionaries
	•	Conditions (if/else)
	•	Loops (for, while)
	•	Functions
	•	Basic problem solving

💡 QA relevance: data handling, test data creation, validations

⸻

🔹 Phase 2: Intermediate Python (Weeks 4–5)

Goal: Write professional code

	•	Modules & packages
	•	Exception handling (try/except)
	•	File handling (txt, csv, json)
	•	OOP (class, object, inheritance)
	•	Virtual environments
	•	pip & libraries

💡 QA relevance: framework design, reusable utilities

⸻

🔹 Phase 3: Python for Automation (Weeks 6–8)

Goal: Become a Python QA Engineer

	•	PyTest framework
	•	Assertions & reports
	•	Test structure & fixtures
	•	Selenium with Python
	•	Page Object Model (POM)
	•	API automation (requests library)

💡 Direct Citi relevance: regression automation, API testing

⸻

🔹 Phase 4: Advanced QA Skills (Weeks 9–10)

Goal: Stand out in interviews

	•	Logging
	•	Config files
	•	Data-driven testing
	•	Parallel execution
	•	DB testing with Python
	•	CI basics (Jenkins overview)

⸻

🔹 Phase 5: Interview & Real-World Practice (Weeks 11–12)

Goal: Get selected

	•	Python coding questions (QA level)
	•	Automation framework design questions
	•	Debugging exercises
	•	Mock interview questions (Citi-style)

==========

Explain Python variables with QA test case examples

Explain Python data types with examples used in automation testing

Explain Python lists and dictionaries with test data examples

Explain if-else conditions with API response validation examples

Explain loops in Python using multiple test case execution example