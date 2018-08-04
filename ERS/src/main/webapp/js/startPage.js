let xho = new XMLHttpRequest();

let btnE = document.getElementById("EmpSignIn");
btnE.addEventListener("click",ajaxA("loginE.do"));

let btnM = document.getElementById("MgrSignIn");
btnM.addEventListener("click",ajaxA("loginM.do"));

/** function */
function ajaxA(u)
{
    if (document.forms['Sign-inForm'].username.value === null ||
            document.forms['Sign-inForm'].password.value === null) {
        alert("Both Fields must have data!");
    }//end if
    else {
        document.getElementById('username').value = '';
        document.getElementById('password').value = '';

        if(xho.readyState === 4 && xho.status === 200) {
            console.log(xho.responseText);
            window.location.href = xho.responseText;
        }//end if
        xho.open("get",u);
        xho.send(document.getElementById("username"), document.getElementById("password"));
    }//end else
}//end ajax()