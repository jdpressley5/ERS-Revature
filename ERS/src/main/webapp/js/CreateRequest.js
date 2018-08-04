let url = "";
let xho = new XMLHttpRequest();
let btn = document.getElementById("SubmitReimb");
btn.addEventListener("click",ajax);

/** function */
function ajax() {
    if(xho.readyState === 4 && xho.status === 200)
        { window.location.href = xho.responseText; }
    xho.open("get",url);
    xho.send(getData);
}//end ajax()

/**function */
function getData() {
    let data = Object();
    data.id = document.getElementById("eid");
    data.message = document.getElementById("message");
    data.amount = document.getElementById("amount");
    return JSON.stringify(data);
}//end getData()