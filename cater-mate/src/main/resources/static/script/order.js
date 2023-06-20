// below is creating mock data, not needed for the actual Spring boot run
//let data = [
//  ["Taco Pack", 35],
//  ["Burrito Pack", 30],
//  ["Enchilada Pack", 35],
//];
//
//let list = document.getElementById("menu");
//
//data.forEach((item) => {
//  let tr = document.createElement("tr");
//  let td0 = document.createElement("td");
//  let td1 = document.createElement("td");
//  let td2 = document.createElement("td");
//  let td3 = document.createElement("td");
//
//  td0.innerText = item[0];
//  td1.innerText = item[1];
//
//  let quantity = document.createElement("input");
//  quantity.value = 1;
//  td2.appendChild(quantity);
//
//  let subtotal = document.createElement("input");
//  subtotal.value = item[1];
//  td3.appendChild(subtotal);
//
//  tr.appendChild(td0);
//  tr.appendChild(td1);
//  tr.appendChild(td2);
//  tr.appendChild(td3);
//
//  list.appendChild(tr);
//});

let ele = document.getElementById("feedback");

function validate() {
  let cateringDate = document.getElementById("cateringDate");

  if (cateringDate.value == undefined || cateringDate.value == "") {
    alert("Please provide Catering Date!");
    cateringDate.focus();
    return false;
  } else if (!check_date(cateringDate.value)) {
    alert("Invalid Catering Date!");
    cateringDate.focus();
    return false;
  }

  let readyTime = document.getElementById("readyTime");

  if (readyTime.value == undefined || readyTime.value == "") {
    alert("Please provide Kitchen Ready Time!");
    readyTime.focus();
    return false;
  } else if (!check_time(readyTime.value)) {
    alert("Please provide Kitchen Ready Time in the correct format!");
    readyTime.focus();
    return false;
  }

  return true;
}

function check_date(date_input) {
  let re = new RegExp(
    /^20\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/
  );

  return re.test(date_input);
}

function check_time(time_input) {
  let re = new RegExp(/^([0-1]\d|2[0-3]):[0-5]\d$/);

  return re.test(time_input);
}
