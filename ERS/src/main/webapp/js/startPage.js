let urlE = "loginE.do";
let urlM = "loginM.do";
let xho = new XMLHttpRequest();

let btnE = document.getElementById("EmpSignIn");
btnE.addEventListener("click",ajaxA(urlE));
let btnM = document.getElementById("EmpSignIn");
btnM.addEventListener("click",ajaxA(urlM));

/** function */
function ajaxA(u)
{
    if (document.forms['Sign-inForm'].username.value === null ||
            document.forms['Sign-inForm'].password.value === null) {
        alert("Both Fields must have data!");
    }//end if
    else {
        if(xho.readyState === 4 && xho.status === 200) {
            console.log(xho.responseText);
            window.location.href = xho.responseText; 
        }//end if
        xho.open("get",u);
        xho.send(getData);
    }//end else
}//end ajax()

/**function */
function getData() {
    let data = Object();
    data.username = document.getElementById("username");
    data.password = document.getElementById("password");
    return JSON.stringify(data);
}//end getData()