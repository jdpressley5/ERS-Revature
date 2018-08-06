/** Javascript Master
 * Contains javascript for all pages to use.
 * @version 1.0
 * @author Joshua Pressley */

 /** reference to the error page */
 const ERRORPAGE = "http://localhost:8080/ERS/HTML/404.html";
 /** reference to success page */
 const SUCCESSPAGE = "http://localhost:8080/ERS/HTML/success.html";

/** startPage.html 
 * function to sign in manager*/
function mSignIn() {
    let url = 'loginM.do';
    let home = "http://localhost:8080/ERS/HTML/MHome.html";
    signin(url,home);
}//end mSign()

/** startPage.html 
 * Function to sign in employee */
function eSignIn() {
    let url = 'loginE.do';
    let home = "http://localhost:8080/ERS/HTML/EHome.html";
    signin(url,home);
}//end eSignIn()

/** startPage.html
 * Function to sign in the user */
function signin(url, home)
{
    let data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        }
    ).then(function(response) {
        if (response.ok) { window.location.assign(home); }
        throw new Error('Response from server was not good.');
    });
}//end signIn()

/**Function to change page w/o sending data */
function changePage(url,home) {
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) { window.location.assign(home); }
        window.location.assign(ERRORPAGE);//error occurred
    });
}//end changePage()

/** EHome.html & MHome.html 
 * Logs out the user */
function logout() {
    let url = 'logout.do';
    let home = "http://localhost:8080/ERS/HTML/logout.html";
    changePage(url,home);
}//end logout()

/** EHome.html & MHome.html  
 * View pending requests */
function pending() {
    let url = 'pending.do';
    let home = "http://localhost:8080/ERS/HTML/viewPendingRequests.html";
    changePage(url,home);
}//end pending()

/** EHome.html & MHome.html 
 * View resolved Requests */
function resolved() {
    let url = 'resolved.do';
    let home = "http://localhost:8080/ERS/HTML/viewResolvedRequests.html";
    changePage(url,home);
}//end resolved()

/** MHome.html  
 * Create an Employee */
function registerE() {
    let url = 'create.do';
    let home = "http://localhost:8080/ERS/HTML/registerEmployee.html";
    changePage(url,home);
}//end registerE()

/** MHome.html
 * Gets list of all Employees */
function getEmployees() {
    let url = 'profiles.do';
    let home = "http://localhost:8080/ERS/HTML/viewAllEmployees.html";
    changePage(url,home);
}//end getEmployees()

/** TODO */
function submitR()
{

}

/** TODO */
function register()
{

}

/** TODO */
function updateE()
{

}

/** TODO */
function toUpdate()//TODO fix me in html employee profile page
{

}

/** TODO */
function getEmployee()
{

}

/** TODO */
function returnToLogin()
{

}