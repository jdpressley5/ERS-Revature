/** Javascript Master
 * Contains javascript for all pages to use.
 * @version 1.0
 * @author Joshua Pressley */

 /** reference to the error page */
 const ERRORPAGE = "http://localhost:8080/ERS/HTML/404.html";
 /** reference to success page */
 const SUCCESSPAGE_M = "http://localhost:8080/ERS/HTML/successM.html";
  /** reference to success page */
  const SUCCESSPAGE_E = "http://localhost:8080/ERS/HTML/successE.html";
/** Reference to manager home */
 const MHOME = "http://localhost:8080/ERS/HTML/MHome.html";
/** Reference to employee Home */
 const EHOME = "http://localhost:8080/ERS/HTML/EHome.html";

/** startPage.html 
 * function to sign in manager*/
function mSignIn() {
    let data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
    let url = 'loginM.do';
    let home = MHOME;
    sendPostData(url,home,data);
}//end mSign()

/** startPage.html 
 * Function to sign in employee */
function eSignIn() {
    let data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
    let url = 'loginE.do';
    let home = EHOME;
    sendPostData(url,home,data);
}//end eSignIn()

/** EHome.html & MHome.html 
 * Logs out the user */
function logout() {
    let url = 'logout.do';
    let home = "http://localhost:8080/ERS/HTML/logout.html";
    changePage(url,home);
}//end logout()

/** EHome.html & MHome.html 
 * View resolved Requests */
function requests() {
    let home = "http://localhost:8080/ERS/HTML/Requests.html";
    window.location.assign(home);
}//end resolved()

/** MHome.html  
 * Go to Create an Employee */
function registerE() {
    let home = "http://localhost:8080/ERS/HTML/registerEmployee.html";
    window.location.assign(home);
}//end registerE()

/** MHome.html
 * go to view of all Employees */
function viewAll() {
    fetch(
        'profiles.do',
        {
            method: 'get',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) { 
            let contents = response.text();
            // let contents = JSON.parse(response.text)
            document.getElementById("contnets").innerHTML = contents;
        }
        else { window.location.assign(ERRORPAGE); }//error occurred
    });
}//end getEmployees()

/** Goes to view employees page */
function toViewAll()
{ window.location.assign("http://localhost:8080/ERS/HTML/viewAllEmployees.html"); }

/** createRequest.html
 * Submits a request for reimbursement */
function submitR() {
    let data = {
        message: document.getElementById("message").value,
        eid: document.getElementById("eid").value,
        amount: document.getElementById("amount").value
    };
    let url = "subReq.do";
    let home = SUCCESSPAGE_E;
    sendPostData(url,home,data);
}//end submitR()

/** updateEmployee.html 
 * Updates employee information */
function updateE() {
    let data = {
        username: document.getElementById("Username").value,
        password: document.getElementById("Password").value,
        lname: document.getElementById("LastName").value,
        fname: document.getElementById("FirstName").value,
        email: document.getElementById("Email").value,
        eid: document.getElementById("eid").value,
        address: document.getElementById("Address").value
    };
    let url = "update.do";
    let home = SUCCESSPAGE_E;
    sendPostData(url,home,data);
}//end updateE()

/** Change to update information page */
function toUpdate() {
    let home = "http://localhost:8080/ERS/HTML/updateEmployee.html";
    window.location.assign(home);
}//end toUpdate()


/** Change to update information page */
function toCreate() {
    let home = "http://localhost:8080/ERS/HTML/createRequest.html";
    window.location.assign(home);
}//end toCreate()

/** Gets information for a single employee */
function getEmployee()
{
    fetch(
            'viewE.do',
            {
                method: 'GET',
                headers: {'Content-Type': 'application/json'}
            }
        ).then(function(response) {
            if (response.ok) { 
            	window.location.assign("http://localhost:8080/ERS/HTML/viewEmployee.html");
                let contents = JSON.parse(response.text);
                document.getElementById("contents").text = contents;
            }
            else { window.location.assign(ERRORPAGE); }//error occurred
        });
}//end getEmployee

function pending()
{
    fetch(
        'pending.do',
        {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) { 
            let contents = response.text;
            // let contents = JSON.parse(response.text);
            document.getElementById("requestsTable").innerHTML = contents;
        }
        else { window.location.assign(ERRORPAGE); }//error occurred
    });
}//end pending()

function resolved() 
{
    fetch(
        'resolved.do',
        {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) { 
            let contents = response.text();
            document.getElementById("requestsTable").innerHTML = contents;
        }
        else { window.location.assign(ERRORPAGE); }//error occurred
    });
}//end resolved()

/** logout.html 
 * Change pages back to the login page */
function returnToLogin() {
    let home = "http://localhost:8080/ERS/HTML/startPage.html";
    window.location.assign(home);
}//end returnToLogin()

function requestsEmp() {
    let home = "http://localhost:8080/ERS/HTML/RequestsEmp.html";
    window.location.assign(home); 
}

/** registerEmployee.html
 * Creates an employee */
function createE() {
    let data = {
        username: document.getElementById("Username").value,
        password: document.getElementById("Password").value,
        lname: document.getElementById("LastName").value,
        fname: document.getElementById("FirstName").value
    };
    let url = "create.do";
    let home = SUCCESSPAGE_M;
    console.log("herer");
    sendPostData(url,home,data);
}//end createEmp()

/** Approve a request */
function aprv() {
    let data = {
        message: document.getElementById("message").value,
        rid: document.getElementById("rid").value
    };
    let url = 'aprv.do';
    let home = SUCCESSPAGE_M;
    sendPostData(url,home,data);
}//end Approve()

/**Deny a request */
function dny() {
    let data = { 
        message: document.getElementById("message").value,
        rid: document.getElementById("rid").value
    };
    let url = 'deny.do';
    let home = SUCCESSPAGE_M;
    sendPostData(url,home,data);
}//end deny()

//---------------------------------------

/** Posts data and changes page */
function sendPostData(url,home,data) {
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        }
    ).then(function(response) {
        if (response.ok) { window.location.assign(home); }
        else { window.location.assign(ERRORPAGE); } //error occurred
    });
}//end sendPostData

/**Function to change page w/o sending data */
function changePage(url,home) {
    fetch(
        url,
        {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) { window.location.assign(home); }
        else { window.location.assign(ERRORPAGE); }//error occurred
    });
}//end changePage()