-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-07-26 19:14:12.204

-- foreign keys
ALTER TABLE Reimbursements
    DROP CONSTRAINT Employee_Reimbursements;

ALTER TABLE Reimbursements
    DROP CONSTRAINT Manager_Reimbursements;

ALTER TABLE R_Content
    DROP CONSTRAINT Reimbursements_R_Content;

-- tables
DROP TABLE Employee;

DROP TABLE Manager;

DROP TABLE R_Content;

DROP TABLE Reimbursements;

-- sequences
DROP SEQUENCE genContentNum;

DROP SEQUENCE genEmployeeNum;

DROP SEQUENCE genManagerNum;

DROP SEQUENCE genReimbursmentNum;

--Procedures/functions

drop procedure INSERT_MANAGER

drop procedure INSERT_EMPLOYEE

drop function GET_PASSWORD_HASH

drop procedure INSERT_REIMBURSEMENT_EMPLOYEE

drop procedure REPLY_REIMBURSEMENT

drop procedure UPDATE_MANAGER

drop procedure UPDATE_EMPLOYEE

drop function SIGN_IN_EMP

drop function SIGN_IN_MGR

-- End of file.

