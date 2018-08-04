let profile = "";
let pending = "";
let resolved = "";
let logout = "";

let btnProfile = document.getElementById('profilebtn');
let btnPending = document.getElementById('viewPending');
let btnResolved = document.getElementById('viewPending');
let btnLogout = document.getElementById('viewPending');

let xho = new XMLHttpRequest();

btnLogout.addEventListener("click", ajax(logout));
btnPending.addEventListener("click",ajax(pending));
btnResolved.addEventListener("click", ajax(resolved));
btnProfile.addEventListener("click", ajax(profile));

function ajax(u : string)
{
    if(xho.readyState === 4 && xho.status === 200)
        { window.location.href = xho.responseText; }
    xho.open("get",u);
    xho.send();
}//end ajax()