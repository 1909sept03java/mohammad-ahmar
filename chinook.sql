--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'kidsbop');
INSERT INTO GENRE (GENREID, NAME) VALUES (27 , 'POP');

--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (9 , 'BILLY' ,'BOB');
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (10, 'BILLY' , 'BOD');
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (62, 'BILLY', 'BOB', 'BILLYBOB@GMAIL.COM');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'BOB', 'BILLY', 'BOBBILLY@GMAIL.COM');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID)
    ON DELETE CASCADE;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'WALTER';
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GETTIME RETURN TIMESTAMP IS
BEGIN RETURN SYSDATE; END;
DECLARE
    TODAY TIMESTAMP;
BEGIN
    TODAY := GETTIME;
    DBMS_OUTPUT.PUT_LINE(TODAY);
END;
/
--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GETLENGTH(X IN VARCHAR2) 
RETURN INTEGER AS Z VARCHAR(200);
BEGIN 
    Z := LENGTH(X);
    RETURN Z;
END;
/
SELECT GETLENGTH(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION GETAVG
RETURN NUMBER AS Z NUMBER;
BEGIN 
    SELECT AVG(TOTAL) INTO Z FROM INVOICE;
    RETURN Z;
END;
/
SELECT GETAVG FROM DUAL;
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST
RETURN NUMBER AS Z NUMBER (10, 2);
BEGIN 
    SELECT MAX(UNITPRICE) INTO Z FROM TRACK;
    RETURN Z;
END;
/
SELECT MOST FROM DUAL;
--3.3
--Task – Create a function that returns the average price of invoice line items in the invoiceline table
CREATE OR REPLACE FUNCTION AVGINVOICE
RETURN NUMBER AS Z NUMBER;
BEGIN 
    SELECT AVG(UNITPRICE) INTO Z FROM INVOICELINE;
    RETURN Z;
END;
/
SELECT AVGINVOICE FROM DUAL;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION BORNAFTER(X DATE)
RETURN SYS_REFCURSOR IS REFCUR SYS_REFCURSOR;
BEGIN
    OPEN REFCUR FOR 'select firstname, lastname from employee 
    where birthdate >= :x' USING X;
    RETURN REFCUR;
END;
/

DECLARE 
X DATE;
FN EMPLOYEE.FIRSTNAME%TYPE;
LN EMPLOYEE.LASTNAME%TYPE;
RETURNCUR SYS_REFCURSOR;
BEGIN
X := TO_DATE('1968', 'yyyy');
SELECT BORNAFTER(X) INTO RETURNCUR FROM DUAL;
DBMS_OUTPUT.PUT_LINE('here');
    LOOP
        FETCH RETURNCUR INTO FN, LN;
        EXIT WHEN RETURNCUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FN || ' ' || LN);
    END LOOP;
END;
/
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GETEMPLOYEENAME(S OUT SYS_REFCURSOR)
AS BEGIN
 OPEN S FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE
    S SYS_REFCURSOR;
    FN EMPLOYEE.FIRSTNAME%TYPE;
    LN EMPLOYEE.LASTNAME%TYPE;
BEGIN 
    GETEMPLOYEENAME(S);
    LOOP 
        FETCH S INTO FN, LN;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FN || ', ' || LN);
    END LOOP;
    CLOSE S;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATEPERSONALEMPLOYEE(NEWEMAIL IN VARCHAR2, EMPLOYEEID IN NUMBER)
AS BEGIN
    UPDATE EMPLOYEE SET EMAIL = NEWEMAIL WHERE EMPLOYEEID = EMPLOYEE.EMPLOYEEID;
    COMMIT;
END;
/
SELECT FIRSTNAME, LASTNAME, EMAIL FROM EMPLOYEE WHERE EMPLOYEEID = 7;
BEGIN
    UPDATEPERSONALEMPLOYEE('newemail@email.com', 7);
END;
/
--Task – Create a stored procedure that returns the managers of an employee.

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GETCOMPNAME(COMPNAME OUT VARCHAR2, FN OUT VARCHAR2, LN OUT VARCHAR2, CID IN NUMBER)
AS BEGIN
    SELECT COMPANY INTO COMPNAME FROM CUSTOMER WHERE CUSTOMERID = CID;
    SELECT FIRSTNAME INTO FN FROM CUSTOMER WHERE CUSTOMERID = CID;
    SELECT LASTNAME INTO LN FROM CUSTOMER WHERE CUSTOMERID = CID;
END;
/
DECLARE
    CNAME VARCHAR2(200);
    NF VARCHAR2(200);
    NL VARCHAR2(200);
    CID NUMBER;
BEGIN
    CID := 5;
    GETCOMPNAME(CNAME, NF, NL, CID);
    DBMS_OUTPUT.PUT_LINE(CNAME || ' ' || NF || ' ' || NL);
END;
/
--5.0
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = 21;
    DELETE FROM INVOICE WHERE INVOICEID = 21;
    COMMIT;
END;
/
SELECT * FROM INVOICE;

CREATE OR REPLACE PROCEDURE INSERTCUST(CID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2, EMAIL IN VARCHAR2)
AS BEGIN
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
        VALUES(CID, FN, LN, EMAIL);
    COMMIT;
END;
/
BEGIN
INSERTCUST(62, 'jd', 'ren', 'myemail@gmail.com');
END;
/
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 62;
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TRIGGERTEST
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('trigger');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TRIGGER1
AFTER UPDATE ON ALBUM 
BEGIN
    DBMS_OUTPUT.PUT_LINE(' it is an update');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TRIGGER3
AFTER DELETE ON CUSTOMER 
BEGIN
    DBMS_OUTPUT.PUT_LINE('deleted');
END;

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT * FROM CUSTOMER C INNER JOIN 
INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL 
FROM CUSTOMER C LEFT OUTER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ART.NAME, AL.TITLE 
FROM ARTIST ART RIGHT JOIN ALBUM AL ON ART.ARTISTID = AL.ARTISTID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ART.NAME FROM ARTIST ART 
CROSS JOIN ALBUM AL WHERE ART.ARTISTID = AL.ARTISTID ORDER BY ART.NAME ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
