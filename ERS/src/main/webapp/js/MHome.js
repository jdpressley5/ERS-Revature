/** function */
function logout()
{
    let url = 'logout.do';
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) {
            window.location.assign("http://localhost:8080/ERS/HTML/logout.html");
        }
        throw new Error('Response from server was not good.');
    }
);
}//end eSign()

/** function */
function pending()
{
    let url = 'pending.do';
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) {
            window.location.assign("http://localhost:8080/ERS/HTML/viewPendingRequests.html");
        }
        throw new Error('Response from server was not good.');
    }
);
}//end eSign()

/** function */
function resolved()
{
    let url = 'resolved.do';
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
        }
    ).then(function(response) {
        if (response.ok) {
            window.location.assign("http://localhost:8080/ERS/HTML/viewResolvedRequests.html");
        }
        throw new Error('Response from server was not good.');
    }
);
}//end eSign()

/** function */
function profiles()
{
    let url = 'profiles.do';
    fetch(
        url,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
        }
    ).then(function(response) {
        if (response.ok) {
            window.location.assign("http://localhost:8080/ERS/HTML/viewAllEmployees.html");
        }
        throw new Error('Response from server was not good.');
    }
);
}//end eSign()

/** function */
function registerE()
{
    let url = 'create.do';
    fetch(
        url,
        {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        }
    ).then(function(response) {
        if (response.ok) {
            // window.location.assign("http://localhost:8080/ERS/HTML/registerEmployee.html");
            window.location.assign("http://localhost:8080/ERS/HTML/success.html");
        }
        throw new Error('Response from server was not good.');
    }
);
}//end eSign()