// /** function */
// function ajaxA(u) {
//     let xho = new XMLHttpRequest();
//     if (xho.readyState === 4 && xho.status === 200) {
//         window.location.href = xho.responseText;
//     } //end if

//     let obj = {
//         username: document.getElementById("username").value,
//         password: document.getElementById("password").value,
//     };

//     xho.open("post", u, true);
//     xho.send(JSON.stringify(obj));
// } //end ajax()

/** function */
function mSign()
{
    let url = 'loginM.do';
    let data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
    fetch(
        url, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data) }
    ).then(res => res.json())
    .catch(error => console.error("Error : ", error))
    .then(console.log("Success ", response))
}

/** function */
function eSign()
{
    let url = 'loginE.do';
    let data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
    fetch(
        url,
        {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        }
    ).then(res => res.json())
    .catch(error => console.error("Error : ", error))
    .then(console.log("Success ", response))
}