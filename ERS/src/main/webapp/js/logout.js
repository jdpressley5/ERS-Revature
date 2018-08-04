let xho = new XMLHttpRequest();
let url = "";
let btn = document.getElementById("loginReturn");
btn.addEventListener("click",ajax);

/** function */
function ajax() {
    if(xho.readyState === 4 && xho.status === 200)
    { window.location.href = xho.responseText; }
    xho.open("get",url);
    xho.send();
}//end ajax