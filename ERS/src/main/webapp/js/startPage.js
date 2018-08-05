/** function */
function ajaxA(u) {
    let xho = new XMLHttpRequest();
    if (xho.readyState === 4 && xho.status === 200) {
        window.location.href = xho.responseText;
    } //end if

    let obj = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    xho.open("post", u, true);
    xho.send(JSON.stringify(obj));
} //end ajax()