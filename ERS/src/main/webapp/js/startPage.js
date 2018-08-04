let urlE = "";
let urlM = "";
let xho = new XMLHttpRequest();
let btnE = document.getElementById("EmpSignIn");
btnE.addEventListener("click",ajax(urlE));
let btnM = document.getElementById("EmpSignIn");
btnM.addEventListener("click",ajax(urlM));

/** function */
function ajax(u : string) {
    if(xho.readyState === 4 && xho.status === 200)
        { window.location.href = xho.responseText; }
    xho.open("get",u);
    xho.send(getData);
}//end ajax()

/**function */
function getData() {
    let data = Object();
    data.username = document.getElementById("username");
    data.password = document.getElementById("password");
    return JSON.stringify(data);
}//end getData()