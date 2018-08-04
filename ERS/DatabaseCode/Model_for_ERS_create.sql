-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-07-26 19:14:12.204

-- tables
-- Table: Employee
CREATE TABLE Employee (
    ID number(10)  NOT NULL,
    FirstName varchar2(100)  NULL,
    LastName varchar2(100)  NULL,
    Username varchar2(100)  NULL,
    Password varchar2(100)  NULL,
    Address varchar2(200),
    Email varchar2(200)  NOT NULL,
    Status varchar2(100) DEFAULT 'Active',
    CONSTRAINT Employee_pk PRIMARY KEY (ID)
) ;

-- Table: Manager
CREATE TABLE Manager (
    ID number(10)  NOT NULL,
    Firstname varchar2(100)  NULL,
    LastName varchar2(100)  NULL,
    Username varchar2(100)  NULL,
    Password varchar2(100)  NULL,
    Address varchar2(200),
    Email varchar2(100)  NOT NULL,
    CONSTRAINT Manager_pk PRIMARY KEY (ID)
) ;

-- Table: R_Content
CREATE TABLE R_Content (
    Content_ID number(10)  NOT NULL,
    Image blob  NULL,
    ReimbursementID number(10)  NULL,
    CONSTRAINT R_Content_pk PRIMARY KEY (Content_ID)
) ;

-- Table: Reimbursements
CREATE TABLE Reimbursements (
    R_ID number(10)  NOT NULL,
    RequestDate date  NULL,
    Employee number(10)  NOT NULL,
    Manager number(10)  NOT NULL,
    Message varchar2(200)  NULL,
    ResponseDate varchar2(200)  NOT NULL,
    ResponseMessage varchar2(200)  NOT NULL,
    Status varchar2(30) default 'Pending',
    Amount number(30) default 0,
    CONSTRAINT Reimbursements_pk PRIMARY KEY (R_ID)
) ;

-- foreign keys

-- Reference: Employee_Reimbursements (table: Reimbursements)
ALTER TABLE Reimbursements ADD CONSTRAINT Employee_Reimbursements
    FOREIGN KEY (Employee)
    REFERENCES Employee (ID);

-- Reference: Manager_Reimbursements (table: Reimbursements)
ALTER TABLE Reimbursements ADD CONSTRAINT Manager_Reimbursements
    FOREIGN KEY (Manager)
    REFERENCES Manager (ID);

-- Reference: Reimbursements_R_Content (table: R_Content)
ALTER TABLE R_Content ADD CONSTRAINT Reimbursements_R_Content
    FOREIGN KEY (ReimbursementID)
    REFERENCES Reimbursements (R_ID);

-- sequences
-- Sequence: genContentNum
CREATE SEQUENCE genContentNum
      INCREMENT BY 1
      NOMINVALUE
      NOMAXVALUE
      START WITH 1000
      NOCACHE
      NOCYCLE;

-- Sequence: genEmployeeNum
CREATE SEQUENCE genEmployeeNum
      INCREMENT BY 1
      NOMINVALUE
      NOMAXVALUE
      START WITH 10000
      NOCACHE
      NOCYCLE;

-- Sequence: genManagerNum
CREATE SEQUENCE genManagerNum
      INCREMENT BY 1
      NOMINVALUE
      NOMAXVALUE
      START WITH 50
      NOCACHE
      NOCYCLE;

-- Sequence: genReimbursmentNum
CREATE SEQUENCE genReimbursmentNum
      INCREMENT BY 1
      NOMINVALUE
      NOMAXVALUE
      START WITH 10001
      NOCACHE
      NOCYCLE;

-- PROCEDURES AND FUNCTIONS
CREATE OR REPLACE FUNCTION GET_PASSWORD_HASH(USERNAME VARCHAR2, PASSWORD VARCHAR2)
RETURN VARCHAR2 IS EXTRA VARCHAR2(10) := 'Pepper';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || PASSWORD || EXTRA)));
END;

------------------------------------

CREATE OR REPLACE TRIGGER EMPLOYEE_BEFORE_INSERT
BEFORE INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
  /* INCREASE THE SEQUENCE */
  IF :NEW.ID IS NULL THEN
    SELECT GENEMPLOYEENUM.NEXTVAL INTO :NEW.ID FROM DUAL;
  END IF;

  /* SAVE HASH INSTEAD OF PASSWORD */
  SELECT GET_PASSWORD_HASH(:NEW.USERNAME,:NEW.PASSWORD) INTO :NEW.PASSWORD FROM DUAL;
END;

------------------------------------

CREATE OR REPLACE TRIGGER MANAGER_BEFORE_INSERT
BEFORE INSERT ON MANAGER FOR EACH ROW
BEGIN
  /* INCREASE THE SEQUENCE */
  IF :NEW.ID IS NULL THEN
    SELECT GENMANAGERNUM.NEXTVAL INTO :NEW.ID FROM DUAL;
  END IF;

  /* SAVE HASH INSTEAD OF PASSWORD */
  SELECT GET_PASSWORD_HASH(:NEW.USERNAME,:NEW.PASSWORD) INTO :NEW.PASSWORD FROM DUAL;
END;

------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_EMPLOYEE
  (FNAME VARCHAR2, LNAME VARCHAR2, UNAME VARCHAR2, PASS VARCHAR2, ADDR varchar2, EM varchar2) AS
BEGIN
  INSERT INTO EMPLOYEE VALUES(NULL, FNAME, LNAME, UNAME, PASS, ADDR, EM, 'ACTIVE');
  COMMIT;
END;

------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_MANAGER
  (FNAME VARCHAR2, LNAME VARCHAR2, UNAME VARCHAR2, PASS VARCHAR2, ADDR varchar2, EM varchar2) AS
BEGIN
  INSERT INTO MANAGER VALUES(NULL, FNAME, LNAME, UNAME, PASS, ADDR, EM);
  COMMIT;
END;

------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_REIMBURSEMENT_EMPLOYEE
  (EMPID INTEGER, MSG varchar2, AMT number) AS
  BEGIN
    INSERT INTO REIMBURSEMENTS VALUES (NULL, sysdate, EMPID, NULL, MSG, NULL, NULL,'Pending',AMT);
    COMMIT;
  END;

------------------------------------

CREATE OR REPLACE TRIGGER REIMBURSEMENT_BEFORE_INSERT
BEFORE INSERT ON REIMBURSEMENTS FOR EACH ROW
BEGIN
  /* INCREASE THE SEQUENCE */
  IF :NEW.R_ID IS NULL THEN
    SELECT GENREIMBURSMENTNUM.NEXTVAL INTO :NEW.R_ID FROM DUAL;
  END IF;
END;

------------------------------------

CREATE OR REPLACE PROCEDURE REPLY_REIMBURSEMENT
  (Mes varchar2, Decision varchar2, id number, MGRid number) AS
  BEGIN
    UPDATE REIMBURSEMENTS SET RESPONSEMESSAGE = Mes, STATUS=Decision, RESPONSEDATE=sysdate, MANAGER=MGRid WHERE R_ID = id;
    COMMIT;
  END;

------------------------------------

CREATE OR REPLACE PROCEDURE UPDATE_MANAGER
  (EID number, FNAME varchar2, LNAME varchar2, UNAME varchar2, PASS varchar2, ADDR varchar2, EM varchar2) AS
BEGIN
  UPDATE MANAGER SET ID=EID,FIRSTNAME=FNAME,LASTNAME=LNAME,USERNAME=UNAME,PASSWORD=PASS,ADDRESS=ADDR,EMAIL=EM
  WHERE ID=EID;
  COMMIT;
END;

------------------------------------

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
  (EID number, FNAME varchar2, LNAME varchar2, UNAME varchar2, PASS varchar2, ADDR varchar2, EM varchar2, STAT varchar2)
  AS
BEGIN
  UPDATE EMPLOYEE SET ID=EID,FIRSTNAME=FNAME,LASTNAME=LNAME,USERNAME=UNAME,PASSWORD=PASS,ADDRESS=ADDR,EMAIL=EM,STATUS=STAT
  WHERE ID=EID;
  COMMIT;
END;

--   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

CREATE OR REPLACE FUNCTION SIGN_IN_EMP (uname varchar2, upass varchar2)
  RETURN NUMBER IS result NUMBER(1);
BEGIN
    SELECT COUNT(username)
    INTO result
    FROM EMPLOYEE
    WHERE username = uname AND password = upass;
    RETURN (result);
END;

--   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

CREATE OR REPLACE FUNCTION SIGN_IN_MGR (uname varchar2, upass varchar2)
RETURN NUMBER IS result NUMBER(1);
BEGIN
  SELECT COUNT(username)
   INTO result
   FROM MANAGER
   WHERE username = uname AND password = upass;
   RETURN (result);
END;

CALL INSERT_MANAGER('ADMIN','ADMIN','ADMIN','ADMIN','Address place...', 'admin@eamil.com');
CALL INSERT_MANAGER('Josh','Pressley','JDP','1234','Address place...', 'jdp@eamil.com');

CALL INSERT_EMPLOYEE('Eryn','Dixon','END','1234','Address place...', 'eryn@eamil.com');
CALL INSERT_EMPLOYEE('Emory','Friedman','ERF','1234','Address place...', 'emory@eamil.com');
CALL INSERT_EMPLOYEE('Michelle','Corn','MLC','1234','Address place...', 'mlc@eamil.com');
CALL INSERT_EMPLOYEE('Christian','Bruce','CBLee','1234','Address place...', 'cblee@eamil.com');
CALL INSERT_EMPLOYEE('Jessica','Morris','JM','1234','Address place...', 'jessica@eamil.com');
-- End of file.
